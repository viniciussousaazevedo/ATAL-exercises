package exerciseList01;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Math.pow;

public class ThePowerSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int initialNumber = sc.nextInt();
        int power = sc.nextInt();

        ArrayList<Integer> possibleBases = new ArrayList<>();
        for (int base = 1; base <= pow(initialNumber, (double) 1 /power); base++) {
            possibleBases.add(base);
        }

        System.out.println(getNumberOfCombinations(initialNumber, power, possibleBases, new ArrayList<>(), new ArrayList<>(), 0).size());

    }

    private static ArrayList<ArrayList<Integer>> getNumberOfCombinations(int initialNumber, int power, ArrayList<Integer> possibleBases, ArrayList<Integer> currentCombination, ArrayList<ArrayList<Integer>> combinations, int currentSum) {

        if (currentSum == initialNumber) {
            if (!combinations.contains(currentCombination)) {
                combinations.add(new ArrayList<>(currentCombination));
                return combinations;
            }
        }

        for (int i = 0; i < possibleBases.size(); i++) {
            Integer currentValue = possibleBases.get(i);
            Integer poweredCurrentValue = (int) pow(currentValue, power);
            currentSum += poweredCurrentValue;

            if (currentSum > initialNumber) {
                break;
            } else if (currentCombination.isEmpty() || poweredCurrentValue > currentCombination.get(currentCombination.size()-1)) {
                possibleBases.remove(i);
                currentCombination.add(poweredCurrentValue);
                combinations = getNumberOfCombinations(initialNumber, power, possibleBases, currentCombination, combinations, currentSum);
                possibleBases.add(i, currentValue);
                currentCombination.remove(poweredCurrentValue);
            }
            currentSum -= poweredCurrentValue;
        }
        return combinations;
    }
}