package com.pratham.DP;

public class FloydWarshallDP {
    public static void main(String[] args) {
        int[][] graph = {
                {0,5,Integer.MAX_VALUE,9,2},
                {Integer.MAX_VALUE, 0, 2, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 7, Integer.MAX_VALUE},
                {4, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 6},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0},
        };

        int[][] shortestPaths = floydsAlgo(graph);

        System.out.println("Shortest Paths between vertices: ");
        for (int i=0;i<shortestPaths.length;i++){
            for (int j=0;j<shortestPaths[i].length;j++){
                System.out.print(shortestPaths[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] floydsAlgo(int[][] graph){
        int n = graph.length;
        int[][] dp = new int[n][n];

        // Initialize dp matrix with the same values as the graph
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j] = graph[i][j];
            }
        }

        // Applying Floyd's algorithm
        for (int k=0;k<n;k++){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    if (dp[i][k]!=Integer.MAX_VALUE && dp[k][j]!=Integer.MAX_VALUE && dp[i][k]+dp[k][j]<dp[i][j]){
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        return dp;
    }
}
