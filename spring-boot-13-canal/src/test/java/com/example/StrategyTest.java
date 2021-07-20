package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-07-14 08:54:29
 */
public class StrategyTest {

    private static Map<String, Function<String,String>> resultDispatcherMuti = new HashMap<>();

    static {
        resultDispatcherMuti.put("校验1",order->String.format("对%s执行业务逻辑1", order));
        resultDispatcherMuti.put("校验2",order->String.format("对%s执行业务逻辑2", order));
        resultDispatcherMuti.put("校验3",order->String.format("对%s执行业务逻辑3", order));
        resultDispatcherMuti.put("校验4",order->String.format("对%s执行业务逻辑4", order));
    }

    public static String getResultDispatcher(String order) {
        Function<String, String> result = resultDispatcherMuti.get(order);
        if (result!=null) {
            return result.apply(order);
        }
        return "不在处理的业务中返回逻辑错误";
    }

    public static void main(String[] args) {
        String result = getResultDispatcher("校验2");
        System.out.println(result);
    }
}
