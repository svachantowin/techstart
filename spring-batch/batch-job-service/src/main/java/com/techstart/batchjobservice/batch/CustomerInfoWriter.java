package com.techstart.batchjobservice.batch;

import com.techstart.batchjobservice.domain.Customer;
import org.springframework.batch.item.ItemWriter;

import javax.annotation.PreDestroy;
import java.io.*;
import java.util.List;

public class CustomerInfoWriter implements ItemWriter<Customer>,Closeable {

    private final PrintWriter writer;

    public CustomerInfoWriter() {
        OutputStream out;
        try {
            out = new FileOutputStream("output.txt");
        } catch (FileNotFoundException e) {
            out = System.out;
        }
        this.writer = new PrintWriter(out);
    }

    @Override
    public void write(final List<? extends Customer> items) throws Exception {
        for (Customer item : items) {
            writer.println(item.toString());
        }
    }

    @PreDestroy
    @Override
    public void close() throws IOException {
        writer.close();
    }

}
