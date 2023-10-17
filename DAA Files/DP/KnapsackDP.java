package com.pratham.DP;
import java.util.Arrays;

class KnapsackDP{
    public static void main(String[] args){
        int[] weight = {1,2,4,5};
        int[] values = {5,10,20,25};
        int W = 6;
        System.out.println("Weight: " + Arrays.toString(weight));
        System.out.println("Values: " + Arrays.toString(values));
        System.out.println("Maximum capacity is: " + W);
        int ans = knapsack(weight,values,weight.length,W);
        System.out.println("Maximum value that we can get is: " + ans);
    }

    static int knapsack(int[] wt, int[] val, int n, int W){
        int[][] dp = new int[n][W+1];

        for(int i=wt[0];i<=W;i++){
            dp[0][i] = val[0];
        }

        for(int index=1;index<n;index++){
            for(int cap=1;cap<=W;cap++){
                int notTaken = 0 + dp[index-1][cap];
                int taken = Integer.MIN_VALUE;
                if(wt[index]<=cap){
                    taken = val[index] + dp[index-1][cap-wt[index]];
                }
                dp[index][cap] = Math.max(notTaken, taken);
            }
        }
        return dp[n-1][W];
    }
}
