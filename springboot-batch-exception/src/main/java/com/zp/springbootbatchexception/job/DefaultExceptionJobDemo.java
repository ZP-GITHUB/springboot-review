package com.zp.springbootbatchexception.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author ZP
 * @date 2021/4/18.
 */
@Component
public class DefaultExceptionJobDemo {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job defaultExceptionJob() {
        return jobBuilderFactory.get("defaultExceptionJob")
                .start(
                        stepBuilderFactory.get("step")
                                .tasklet((stepContribution, chunkContext) -> {
                                    // 获取执行上下文
                                    ExecutionContext executionContext = chunkContext.getStepContext().getStepExecution().getExecutionContext();
                                    if (executionContext.containsKey("success")) {
                                        System.out.println("任务执行成功");
                                        return RepeatStatus.FINISHED;
                                    } else {
                                        String errorMessage = "处理任务过程发生异常";
                                        System.out.println(errorMessage);
                                        // 因为在上次任务抛出异常前，我们在执行上下文中添加successkey（配合MySQL持久化，不会因项目启动而丢失）
                                        executionContext.put("success", true);
                                        throw new RuntimeException(errorMessage);
                                    }

                                }).build()
                ).build();
    }
}