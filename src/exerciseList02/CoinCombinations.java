package exerciseList02;

import java.util.Scanner;

public class CoinCombinations {

    private static final int LIMIT = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] firstInput = sc.nextLine().split(" ");
        int n = Integer.parseInt(firstInput[0]);
        int desiredSum = Integer.parseInt(firstInput[1]);

        String[] secondInput = sc.nextLine().split(" ");
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(secondInput[i]);
        }

        System.out.println(coinCombinations(desiredSum, coins));
    }

    private static int coinCombinations(int desiredSum, int[] coins) {
        int[]  partialsCombinations = new int[desiredSum+1];
        partialsCombinations[0] = 1;

        for (int i = 1; i < partialsCombinations.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int subtractedIndex = i - coins[j];
                partialsCombinations[i] = (partialsCombinations[i] + (subtractedIndex >= 0 ? partialsCombinations[subtractedIndex] : 0)) % LIMIT;
            }
        }
        return partialsCombinations[partialsCombinations.length-1];
    }

}
