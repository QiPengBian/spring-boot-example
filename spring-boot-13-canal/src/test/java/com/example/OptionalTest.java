package com.example;

import java.util.Optional;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-07-13 14:30:42
 */
public class OptionalTest {

    public static void main(String[] args) {
        boolean present = Optional.ofNullable(null)
//               .ifPresent(t-> System.out.println(t));
                .isPresent();
        System.out.println(present);
        System.out.println(Optional.ofNullable(null).orElse(2));
        System.out.println(Optional.ofNullable(null).orElseGet(() -> 2));
    }
}
