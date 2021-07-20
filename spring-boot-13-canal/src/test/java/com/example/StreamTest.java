package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-07-13 13:27:24
 */
public class StreamTest {
    public static void main(String[] args) {
//        Arrays.asList(1, 2, 3).stream()
//                .map(i -> i * 10)
//                .flatMapToDouble(num -> DoubleStream.of((double) num))
//                .forEach(System.out::println);

        AtomicInteger n = new AtomicInteger();
        List<Integer> list01 = Arrays.asList(1, 2, 3);
        List<Integer> list02 = Arrays.asList(4, 5, 6);
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, list01);
        map.put(2, list02);
        map.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .sorted(Comparator.comparing(Integer::new))
                .limit(3)
                .forEach(System.out::println);
//                .parallel()
//                .forEach(s -> {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + ":" + s);
//                });
//                .findFirst()
//                .ifPresent(s -> n.set(s));
//        System.out.println(n.get());
    }
}
