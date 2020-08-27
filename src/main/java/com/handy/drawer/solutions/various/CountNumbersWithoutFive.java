package com.handy.drawer.solutions.various;

import java.util.stream.IntStream;

public class CountNumbersWithoutFive {
    public static int dontGiveMeFive(int start, int end) {
        IntStream values = IntStream.rangeClosed(start, end);
        int number = (int) values
                .filter(i -> doesNotContainCharFive(i) )
                .count();
        return number;
    }

    private static boolean doesNotContainCharFive(int number) {
        return !String.valueOf(number).contains("5");
    }

    public static void main(String[] args) {
        System.out.println(dontGiveMeFive(1, 20));
    }
}
