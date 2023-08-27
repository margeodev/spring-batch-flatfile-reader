package com.springbatch.flatfile.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FixedLengthFileJobConfig {

    private static final String FIXED_LENGTH_FILE_JOB = "fixedLenghtFileJob";
    private final JobRepository jobRepository;

    @Bean
    public Job fixedLenghtFileJob(Step fixedLengthFileStep) {
        return new JobBuilder(FIXED_LENGTH_FILE_JOB, jobRepository)
                .start(fixedLengthFileStep)
                .build();
    }

}
