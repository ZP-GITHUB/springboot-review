package com.zp.springbootwebflux.webflux;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author ZP
 * @date 2021/5/7.
 */
public class FluxTest {
    public static void main(String[] args) throws InterruptedException {
        Flux.just("Hello", "World").subscribe(System.out::println);
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
        Flux.empty().subscribe(System.out::println);
        Flux.range(1, 4).subscribe(System.out::println);
        Flux.interval(Duration.of(1, ChronoUnit.SECONDS)).subscribe(System.out::println);
        // 线程延迟关闭，不然最后一个例子木有输出
        Thread.currentThread().join(10000);
    }
}
