package com.techstart.batchjobservice.batch;

import com.techstart.batchjobservice.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

@Slf4j
public class TransactionProcessor extends ValidatingItemProcessor<Customer> {

    public TransactionProcessor(final int limit) {
        super(
                item -> {
                    if (item.getTransactions() >= limit) {
                        throw new ValidationException("Customer has more than " + limit + " transactions");
                    }
                    log.info("Customer {} matched the transaction filter", item);
                }
        );
        setFilter(true);
    }

}
