package com.zp.springbootbatchitemprocessor.processor;

import com.zp.springbootbatchitemprocessor.entity.TestData;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author ZP
 * @date 2021/4/18.
 * DOTO 通过自定义ItemProcessor的实现类，我们也可以简单地实现数据过滤
 */
@Component
public class TestDataFilterItemProcessor implements ItemProcessor<TestData, TestData> {
    @Override
    public TestData process(TestData item) {
        // 返回null，会过滤掉这条数据
        return "".equals(item.getField3()) ? null : item;
    }
}