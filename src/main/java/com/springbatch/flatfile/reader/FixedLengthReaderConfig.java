package com.springbatch.flatfile.reader;

import com.springbatch.flatfile.model.Client;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class FixedLengthReaderConfig {

    @Bean
    @StepScope
    public FlatFileItemReader<Client> fixedLenghtFileReader(@Value("#{jobParameters['clientsFile']}") Resource clientsFile) {
        var ranges = new Range[] {new Range(1,10), new Range(11,20), new Range(21, 23), new Range(24, 43)};
        var fileFields = new String[] {"name", "lastName", "age", "email"};
        return new FlatFileItemReaderBuilder<Client>()
                .name("fixedLenghtFileReader")
                .resource(clientsFile)
                .fixedLength()
                .columns(ranges)
                .names(fileFields)
                .targetType(Client.class)
                .build();
    }

}

