package com.handy.drawer.solutions.various;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {
    /**
     * Method receives an array representing a series of unique numbers from 0-N where one value is missing.
     * Method finds and returns the missing value
     *
     * @param inputArray Array representing a series of unique numbers
     * @return
     */
    public static int findMissingElement(Integer[] inputArray) {
        List<Integer> series = new ArrayList(Arrays.asList(inputArray));
        int expectedSeriesSum = (series.size() * (series.size()+1) ) / 2;
        int realSeriesSum = series.stream()
                .mapToInt(e -> e)
                .sum();

        return expectedSeriesSum - realSeriesSum;
    }

    public static void main(String[] args) {
        Integer[] testArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 10}; //Missing number is 9
        System.out.println("Missing number is: " + findMissingElement(testArray));
    }
}
