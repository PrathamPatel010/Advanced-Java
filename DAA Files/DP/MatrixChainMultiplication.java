package com.pratham.DP;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] dimensions = {10,30,5,60};
        int minimumCost = matrixChainOrder(dimensions);
        System.out.println("Minimum Cost of Multiplication: " + minimumCost);
    }

    public static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length; // Number of matrices
        int[][] dp = new int[n][n];

        for (int length = 2; length < n; length++) {
            for (int i = 1; i < n - length + 1; i++) {
                int j = i + length - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dimensions[i - 1] * dimensions[k] * dimensions[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }
}
