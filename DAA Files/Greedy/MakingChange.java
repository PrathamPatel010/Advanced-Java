package com.pratham.Greedy;
import java.util.*;

class MakingChange {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000, 2000 };
        Scanner in = new Scanner(System.in);
        System.out.println("Enter money: ");
        int V = in.nextInt();
        long startTime = System.nanoTime();
        ArrayList<Integer> coinsList = makingChange(coins, V);
        long endTime = System.nanoTime();
        System.out.println("Minimum no. of coins is: " + coinsList.size());
        System.out.println("Coins are: " + coinsList);
        long timeTaken = (endTime - startTime);
        System.out.println("Execution Time: " + timeTaken + " ns");
        in.close();
    }

    static ArrayList<Integer> makingChange(int[] coins, int V) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = coins.length - 1; i >= 0; i--) {
            while (V >= coins[i]) {
                V -= coins[i];
                list.add(coins[i]);
            }
            if (V == 0) {
                break;
            }
        }
        return list;
    }
}
