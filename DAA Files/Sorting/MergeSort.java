package com.pratham.Sorting;
import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        // Best case
        System.out.println("Best Case");
        int[] arr1 = new int[10000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr1));
        long startTime=System.currentTimeMillis();
        arr1 = mergeSort(arr1);
        long endTime=System.currentTimeMillis();
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Execution Time: " + (endTime-startTime) + " ms");
        System.out.println("**********************");

        // Worst Case
        System.out.println("Worst Case");
        int[] arr2 = new int[10000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr2.length - 1 - i;
        }
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr2));
        startTime=System.currentTimeMillis();
        arr2 = mergeSort(arr2);
        endTime=System.currentTimeMillis();
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr2));
        System.out.println("Execution Time: " + (endTime-startTime) + " ms");
        System.out.println("**********************");

        // Average Case
        System.out.println("Average case");
        int[] arr3 = new int[10000];
        int min = 0, max = 10000;
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = min + (int) (Math.random() * ((max - min) + 1));
        }
        System.out.println("Before sorting");
        System.out.println(Arrays.toString(arr3));
        startTime=System.currentTimeMillis();
        arr3 = mergeSort(arr3);
        endTime=System.currentTimeMillis();
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr3));
        System.out.println("Execution Time: " + (endTime-startTime) + " ms");
        System.out.println("**********************");
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
}