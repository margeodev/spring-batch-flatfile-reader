package com.springbatch.flatfile.step;

import com.springbatch.flatfile.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class FixedLengthFileStepConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final static String FIXED_LENGHT_FILE_STEP = "fixedLenghtFileStep";

    @Bean
    public Step fixedLenghtFileStep(ItemReader<Client> reader, ItemWriter<Client> writer) {
        return new StepBuilder(FIXED_LENGHT_FILE_STEP, jobRepository)
                .<Client, Client>chunk(200, transactionManager)
                .reader(reader)
                .writer(writer)
                .build();
    }

}
