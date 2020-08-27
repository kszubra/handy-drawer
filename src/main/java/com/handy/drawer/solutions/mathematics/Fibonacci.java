package com.handy.drawer.solutions.mathematics;

public class Fibonacci {
    public static Long getNFibonacciValue(Long index) {

        if(index == 1 || index == 2) {
            return 1L;
        }
        return getNFibonacciValue(index-2 ) + getNFibonacciValue(index-1 );
    }

    public static void main(String[] args) {
        System.out.println( getNFibonacciValue(19L) == 4181L );
        System.out.println( getNFibonacciValue( 19L ) );


    }
}
