package exerciseList02;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.max;

public class DiceCombinations {

    private static final int LIMIT = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(diceCombinations(num));
    }

    private static int diceCombinations(int num) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if (i <= 1) {
                values.add(1);
                continue;
            }

            int j = max(0, i-6);
            int current = 0;

            while (j < i) {
                current += values.get(j) % LIMIT;
                j++;
            }
            values.add(current % LIMIT);
        }
        return values.get(num) % LIMIT;
    }
}
//package exerciseList02;
//
//import java.util.Scanner;
//
//public class DiceCombinations {
//
//    private static final int LIMIT = 1000000007;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//
//        System.out.println(diceCombinations(num));
//    }
//
//    private static int diceCombinations(int num) {
//        int[] combinations = new int[num+1];
//        combinations[0] = 1;
//        for (int i = 1; i <= num; i++) {
//                combinations[i] = getSum(combinations, i);
//        }
//        return combinations[num] % LIMIT;
//    }
//
//    private static int getSum(int[] combinations, int index) {
//        int sum = 0;
//        for (int i = index-6; i < index; i++) {
//            if (i >= 0) {
//                sum += combinations[i] % LIMIT;
//            }
//        }
//        return sum % LIMIT;
//    }
//}