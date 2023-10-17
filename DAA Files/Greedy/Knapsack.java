package com.pratham.Greedy;
import java.util.*;

class Item{
    int weight;
    int value;

    public Item(int weight,int value){
        this.weight=weight;
        this.value=value;
    }
}
public class Knapsack implements Comparator<Item>{
    public int compare(Item a,Item b){
        double r1 = (double)(a.value)/(double)(a.weight);
        double r2 = (double)(b.value)/(double)(b.weight);
        if (r1<r2) return 1;
        else if(r1>r2) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        int maxWeight=50;
        Item[] arr = {new Item(20,100),new Item(10,60),new Item(30,120)};
        double ans = fractionalKnapsack(maxWeight,arr);
        System.out.println("Maximum value is: " + ans);
    }

    static double fractionalKnapsack(int W,Item[] arr){
        Arrays.sort(arr,new Knapsack());
        int currWeight=0;
        double finalVal=0;

        for (int i=0;i<arr.length;i++){
            if (currWeight+arr[i].weight<=W){
                currWeight+=arr[i].weight;
                finalVal+=arr[i].value;
            } else{
                int remainingWeight = W-currWeight;
                finalVal+= (double)(arr[i].value)/(double)(arr[i].weight) * (double)(remainingWeight);
                break;
            }
        }
        return finalVal;
    }
}