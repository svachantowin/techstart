package com.techstart.batchjobservice.config;

import com.techstart.batchjobservice.batch.BirthdayFilterProcessor;
import com.techstart.batchjobservice.batch.CustomerInfoReader;
import com.techstart.batchjobservice.batch.CustomerInfoWriter;
import com.techstart.batchjobservice.batch.TransactionProcessor;
import com.techstart.batchjobservice.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PreDestroy;
import java.util.Arrays;

@Slf4j
@Configuration
public class ReportJobConfig {

    public static final String TASKLET_STEP = "taskletStep";

    public static final String XML_FILE = "database.xml";

    private static final String JOB_NAME = "customerReportJob";

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobBuilderFactory jobBuilders;

    @Autowired
    private StepBuilderFactory stepBuilders;

    @Autowired
    private JobExplorer jobs;

    @PreDestroy
    public void destroy() throws NoSuchJobException {
        jobs.getJobNames().forEach(name -> log.info("job name: {}", name));
        jobs.getJobInstances(JOB_NAME, 0, jobs.getJobInstanceCount(JOB_NAME)).forEach(
                jobInstance -> {
                    log.info("job instance id {}", jobInstance.getInstanceId());
                }
        );

    }

    @Scheduled(fixedRate = 5000)
    public void run() throws Exception {
        JobExecution execution = jobLauncher.run(
                customerReportJob(),
                new JobParametersBuilder().addLong("uniqueness", System.nanoTime()).toJobParameters()
        );
        log.info("Exit status: {}", execution.getStatus());
    }

    @Bean
    public Job customerReportJob() {
        return jobBuilders.get(JOB_NAME)
                .start(taskletStep())
                .next(chunkStep())
                .build();
    }

    @Bean
    public Step taskletStep() {
        return stepBuilders.get(TASKLET_STEP)
                .tasklet(tasklet())
                .build();
    }

    @Bean
    public Step chunkStep() {
        return stepBuilders.get("chunkStep")
                .<Customer, Customer>chunk(20)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Customer, Customer> processor() {
        final CompositeItemProcessor<Customer, Customer> processor = new CompositeItemProcessor<>();
        processor.setDelegates(Arrays.asList(birthdayFilterProcessor(), transactionValidatingProcessor()));
        return processor;
    }

    @StepScope
    @Bean
    public BirthdayFilterProcessor birthdayFilterProcessor() {
        return new BirthdayFilterProcessor();
    }

    @StepScope
    @Bean
    public TransactionProcessor transactionValidatingProcessor() {
        return new TransactionProcessor(5);
    }

    @StepScope
    @Bean
    public ItemReader<Customer> reader(){
        return new CustomerInfoReader(XML_FILE);
    }

    @StepScope
    @Bean
    public ItemWriter<Customer> writer(){
        return new CustomerInfoWriter();
    }

    @Bean
    public Tasklet tasklet() {
        return (contribution, chunkContext) -> {
            log.info("Executing tasklet step");
            return RepeatStatus.FINISHED;
        };
    }

}
