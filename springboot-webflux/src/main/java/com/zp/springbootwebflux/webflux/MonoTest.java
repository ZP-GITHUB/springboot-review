package com.zp.springbootwebflux.webflux;

import reactor.core.publisher.Mono;

import java.util.Optional;

/**
 * @author ZP
 * @date 2021/5/8.
 */
public class MonoTest {

    public static void main(String[] args) {
        Mono.just("are").subscribe(System.out::println);
        Mono.empty().subscribe(System.out::println);
        Mono.fromSupplier(() -> "you").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("ok")).subscribe(System.out::println);

        Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);
    }
}