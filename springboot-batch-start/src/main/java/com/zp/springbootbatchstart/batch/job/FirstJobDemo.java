package com.zp.springbootbatchstart.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ZP
 * @date 2021/4/17.
 * 任务成功执行了，数据库的库表也将记录相关运行日志。
 * 重新启动项目，控制台并不会再次打印出任务执行日志，因为Job名称和 Step名称组成唯一，
 * 执行完的不可重复的任务，不会再次执行。
 */
@Component
public class FirstJobDemo {

    /**
     * 任务创建工厂
     */
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    /**
     * 步骤创建工厂
     */
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job firstJob(){
        return jobBuilderFactory.get("firstJob")
                .start(step())
                .build();
    }

    /**
     * 步骤Step由若干个小任务Tasklet组成
     * @return
     */
    private Step step() {
        return stepBuilderFactory.get("step")
                .tasklet(((stepContribution, chunkContext) -> {
                    System.out.println("执行步骤....，返回RepeatStatus.FINISHED表示该小任务执行成功，正常结束");
                    return RepeatStatus.FINISHED;
                })).build();
    }


}
