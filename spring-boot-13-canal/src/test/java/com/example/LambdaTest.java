package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Math.random;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-07-13 15:32:12
 */
public class LambdaTest {

    //消费型接口测试
    @Test
    public void Test01() {
        consumer(98.5, x -> System.out.println("今天吃了一条鱼，消费了" + x + "元"));
    }
    public void consumer(Double money, Consumer<Double> doubleConsumer) {
        doubleConsumer.accept(money);
    }

    //供给型接口测试
    @Test
    public void Test02() {
        //产生三个10以内的随机数，并打印出来
        List<Integer> list = getList(3, () -> (int) (random() * 10));
        list.forEach(x -> System.out.println(x));
    }
    //获取number个满足条件的数字
    public List<Integer> getList(int number, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int n = supplier.get();
            list.add(n);
        }
        return list;
    }

    //功能性接口测试
    @Test
    public void Test03() {
        //获取abcdefg字符串的长度
        Integer length = getLength("abcdefg", x -> x.length());
        System.out.println(length);
    }
    //获取字符串的长度
    public Integer getLength(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    //断言型接口测试
    @Test
    public void Test04() {
        List<Integer> list = Arrays.asList(45, 56, 48, 49, 65, 80);
        //找出大于60的数
        List<Integer> integerList = getList(list, s -> s > 60);
        integerList.forEach(x -> System.out.println(x));
    }
    //将满足条件的加入返回
    public List<Integer> getList(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> integers = new ArrayList<>();
        for (Integer i : list) {
            if (predicate.test(i)) {
                integers.add(i);
            }
        }
        return integers;
    }

    @Test
    public void test05(){
        Runnable runnable = () -> {

        };
    }
}
