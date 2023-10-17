package com.pratham.Sorting;
import java.util.*;

public class BubbleSort {
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
        bubble(arr1);
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
        bubble(arr2);
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
        bubble(arr3);
        endTime=System.currentTimeMillis();
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr3));
        System.out.println("Execution Time: " + (endTime-startTime) + " ms");
        System.out.println("**********************");
    }

    // Time Complexity : O(N*N) because nested loops
    static void bubble(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                return;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
