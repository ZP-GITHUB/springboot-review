package com.zp.springbootbatchitemprocessor.job;

import com.zp.springbootbatchitemprocessor.entity.TestData;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.validator.BeanValidatingItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ZP
 * @date 2021/4/18.
 */
@Component
public class BeanValidatingItemProcessorDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ListItemReader<TestData> simpleReader;

    @Bean
    public Job beanValidatingItemProcessorJob() throws Exception {
        return jobBuilderFactory.get("beanValidatingItemProcessorJob")
                .start(step())
                .build();
    }

    private Step step() throws Exception {
        return stepBuilderFactory.get("step")
                .<TestData, TestData>chunk(2)
                .reader(simpleReader)
                .processor(beanValidatingItemProcessor())
                .writer(list -> list.forEach(System.out::println))
                .build();
    }

    private BeanValidatingItemProcessor<TestData> beanValidatingItemProcessor() throws Exception {
        BeanValidatingItemProcessor<TestData> beanValidatingItemProcessor = new BeanValidatingItemProcessor<>();
        // 开启过滤，不符合规则的数据被过滤掉；
        // 如果不开启过滤beanValidatingItemProcessor.setFilter(false)，那么在遇到不符合注解校验规则的数据，
        // 将抛出异常
        beanValidatingItemProcessor.setFilter(true);
        beanValidatingItemProcessor.afterPropertiesSet();
        return beanValidatingItemProcessor;
    }
}