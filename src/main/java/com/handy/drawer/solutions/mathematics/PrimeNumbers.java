package com.handy.drawer.solutions.mathematics;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    public static boolean isPrime(int n, List<Integer> previousPrimes) {
        if(n%2 == 0) {
            return false;
        }
        for(Integer prime : previousPrimes) {
            if(n%prime == 0) {
                return false;
            }
        }
        return true;
    }

    public static void findPrimes(int amountToFind) {
        List primes = new ArrayList();
        primes.add(2);

        for(int i = 2; primes.size() < amountToFind; i++) {
            if( isPrime(i, primes) ) {
                primes.add(i);
                System.out.println(i);
            }
        }

        System.out.println("Number of found primes: " + primes.size());
    }

    public static void main(String[] args) {
        findPrimes(60000);
    }
}
