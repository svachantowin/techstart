package com.techstart.batchjobservice.batch;

import com.techstart.batchjobservice.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.IteratorItemReader;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Slf4j
public class CustomerInfoReader implements ItemReader<Customer> {
    private final String filename;

    private ItemReader<Customer> delegate;

    public CustomerInfoReader(final String filename) {
        this.filename = filename;
    }

    @Override
    public Customer read() throws Exception {
        if (delegate == null) {
            log.info("Creating iterator item reader");
            delegate = new IteratorItemReader<>(customers());
        }
        log.info("Reading next customer");
        return delegate.read();
    }

    private List<Customer> customers() throws FileNotFoundException {
        try (XMLDecoder decoder = new XMLDecoder(new FileInputStream(filename))) {
            return (List<Customer>) decoder.readObject();
        }
    }

}
