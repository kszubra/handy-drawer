package com.handy.drawer.solutions.various;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortOddNumbers {
    public static int[] sortArray(int[] array) {
        int size = array.length;
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> oddIndexes = new ArrayList<>();

        for(int i=0; i<size; i++) {
            if(array[i]%2 != 0) {
                oddNumbers.add(array[i]);
                oddIndexes.add(i);
            }
        }

        oddNumbers.sort(Comparator.naturalOrder());
        int counter = 0;

        for(Integer number : oddNumbers) {
            array[oddIndexes.get(counter)] = number;
            counter++;
        }
        return array;
    }

    public static void main(String[] args) {

        sortArray(new int[]{ 5, 3, 2, 8, 1, 4 });

    }
}
