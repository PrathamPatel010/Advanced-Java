package com.pratham.DP;
import java.util.*;

class MakingChangeDP{
    public static void main(String[] args) {
        int[] values = {0,1,4,5};
        int n = values.length;
        int change = 10;
        System.out.println("Coins are: " + Arrays.toString(values));
        System.out.println("Change: " + change);
        int[][] dp=new int[n][change+1];
        int answer = makingChange(dp,change,values,n);
        System.out.println("Minimum no of Coins required: " + answer);
    }

    static int makingChange(int[][] dp,int change,int[] values,int n){
        // generating table
        for(int i=0;i<n;i++){
            for(int j=0;j<=change;j++){
                if(i==0){
                    dp[i][j]=0;
                }
                if(j==0){
                    dp[i][j]=0;
                }
                if(j>=1&&i>=1){
                    if(i==1){
                        dp[i][j]=1+dp[i][j-values[i]];
                    }
                    else if(j<values[i]){
                        dp[i][j]=dp[i-1][j];
                    }
                    else{
                        dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-values[i]]);
                    }
                }
            }
        }
        System.out.println("Table: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<=change;j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return dp[dp.length-1][change];
    }
}