package com.springbatch.flatfile.writer;

import com.springbatch.flatfile.model.Client;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FixedLengthWriterConfig {

    @Bean
    public ItemWriter<Client> fixedLenghtFileWriter() {
        return items -> items.forEach(System.out::println);
    }
}