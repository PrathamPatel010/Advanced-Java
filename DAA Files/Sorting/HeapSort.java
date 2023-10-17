package com.pratham.Sorting;
import java.util.*;

public class HeapSort {
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
        heapSort(arr1);
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
        heapSort(arr2);
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
        heapSort(arr3);
        endTime=System.currentTimeMillis();
        System.out.println("After sorting");
        System.out.println(Arrays.toString(arr3));
        System.out.println("Execution Time: " + (endTime-startTime) + " ms");
        System.out.println("**********************");
    }

    public static void heapSort(int[] array) {
        int n = array.length;
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Heap sort
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // Heapify the reduced heap
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && array[left] > array[largest])
            largest = left;

        // If right child is larger than current largest
        if (right < n && array[right] > array[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            // Swap the largest element with the root
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }
}