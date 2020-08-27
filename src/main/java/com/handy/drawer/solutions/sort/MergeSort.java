package com.handy.drawer.solutions.sort;

import java.util.Arrays;

public class MergeSort {
    private static void merge (
            int[] arrayToSort,
            int[] leftHalf,
            int[] rightHalf,
            int leftArrayEndIndex,
            int rightArrayStartIndex ) {

        int i = 0, j = 0, k = 0;

        while (i < leftArrayEndIndex && j < rightArrayStartIndex) {
            if (leftHalf[i] <= rightHalf[j]) {
                arrayToSort[k++] = leftHalf[i++];
            }
            else {
                arrayToSort[k++] = rightHalf[j++];
            }
        }
        while (i < leftArrayEndIndex) {
            arrayToSort[k++] = leftHalf[i++];
        }
        while (j < rightArrayStartIndex) {
            arrayToSort[k++] = rightHalf[j++];
        }
    }

    private static void mergeSort(int[] arrayToSort, int arrayLength) {
        if (arrayLength < 2) {
            return;
        }
        int middleIndex = arrayLength / 2;
        /**
         * Creating arrays for left and right half of the array
         */
        int[] leftHalf = new int[middleIndex];
        int[] rightHalf = new int[arrayLength - middleIndex];

        /**
         * Adding values from starting array to left and right arrays
         */
        for (int i = 0; i < middleIndex; i++) {
            leftHalf[i] = arrayToSort[i];
        }
        for (int i = middleIndex; i < arrayLength; i++) {
            rightHalf[i - middleIndex] = arrayToSort[i];
        }

        /**
         * Recursively repeat for created left and right arrays
         */
        mergeSort(leftHalf, middleIndex);
        mergeSort(rightHalf, arrayLength - middleIndex);

        /**
         * merge results
         */
        merge(arrayToSort, leftHalf, rightHalf, middleIndex, arrayLength - middleIndex);
    }

    public static void sort(int[] arrayToSort) {
        mergeSort(arrayToSort, arrayToSort.length);
    }



    public static void main(String[] args) {
        int[] exampleArray = {125, 56, 45, 1, 789, 52, 66, 42, 83, 15, 47, 35, 415, 95, 125, 17};

        System.out.println("Unsorted array: " + Arrays.toString(exampleArray));
        sort(exampleArray);
        System.out.println("Sorted array: " + Arrays.toString(exampleArray));
    }
}
