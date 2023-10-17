package com.pratham.Sorting;
import java.util.*;

public class QuickSort {
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
        quick(arr1, 0, arr1.length - 1);
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
        quick(arr2, 0, arr2.length - 1);
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
        quick(arr3, 0, arr3.length - 1);
        endTime=System.currentTimeMillis();
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr3));
        System.out.println("Execution Time: " + (endTime-startTime) + " ms");
        System.out.println("**********************");
    }

    static void quick(int[] arr, int lower, int upper) {
        if (lower > upper) {
            return;
        }

        int start = lower;
        int end = upper;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        // now pivot element is at correct index, sort 2 halves of the array
        quick(arr, lower, end);
        quick(arr, start, upper);
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
