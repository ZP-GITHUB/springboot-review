package com.zp.springbootbatchitemreader.job;

import com.zp.springbootbatchitemreader.reader.MySimpleIteamReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZP
 * @date 2021/4/17.
 */
@Component
public class MySimpleItemReaderDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job mySimpleItemReaderJob() {
        return jobBuilderFactory.get("mySimpleItemReaderJob")
                .start(step())
                .build();
    }

    private Step step() {
        return stepBuilderFactory.get("step")
                .<String, String>chunk(2)  // 使用chunk()方法。chunk字面上的意思是“块”的意思，可以简单理解为数据块，泛型<String, String>用于指定读取的数据和输出的数据类型，构造器入参指定了数据块的大小
                .reader(mySimpleItemReader())
                .writer(list -> list.forEach(System.out::println))  // 简单输出，后面再详细介绍writer
                .build();
    }

    private ItemReader<String> mySimpleItemReader() {
        List<String> data = Arrays.asList("java", "c++", "javascript", "python");
        return new MySimpleIteamReader(data);
    }
}