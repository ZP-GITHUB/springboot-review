package com.zp.springbootbatchitemprocessor.processor;

import com.zp.springbootbatchitemprocessor.entity.TestData;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @author ZP
 * @date 2021/4/18.
 */
@Component
public class TestDataTransformItemPorcessor implements ItemProcessor<TestData, TestData> {
    @Override
    public TestData process(TestData item) {
        // field1值拼接 hello
        item.setField1(item.getField1() + " hello");
        return item;
    }
}