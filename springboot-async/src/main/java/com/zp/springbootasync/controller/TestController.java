package com.zp.springbootasync.controller;

import com.zp.springbootasync.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ZP
 * @date 2021/4/30.
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestService testService;

    @GetMapping("async")
    public void testAsync() {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");
//        testAsync方法耗时极少，因为异步的原因，程序并没有被sleep方法阻塞，这就是异步调用的好处。
//        同时异步方法内部会新启一个线程来执行
        testService.asyncMethod();

        logger.info("异步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }

    @GetMapping("sync")
    public void testSync() {
        long start = System.currentTimeMillis();
        logger.info("同步方法开始");

        testService.syncMethod();

        logger.info("同步方法结束");
        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
    }

    @GetMapping("asyncFutureMethod")
    public String testaSyncFutureMethod() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        logger.info("异步方法开始");

        Future<String> stringFuture = testService.asyncFutureMethod();
        String result = stringFuture.get();
        logger.info("异步方法返回值：{}", result);

        logger.info("异步方法结束");

        long end = System.currentTimeMillis();
        logger.info("总耗时：{} ms", end - start);
        return stringFuture.get();
    }
}