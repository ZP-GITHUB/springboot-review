package com.zp.springbootbatchitemreader.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.lang.Nullable;

import java.util.Iterator;
import java.util.List;

/**
 * @author ZP
 * @date 2021/4/17.
 */
public class MySimpleIteamReader implements ItemReader<String> {
    private Iterator<String> iterator;

    public MySimpleIteamReader(List<String> data) {
        this.iterator = data.iterator();
    }

    @Override
    public String read() {
        // 数据一个接着一个读取
        return iterator.hasNext() ? iterator.next() : null;
    }
}
