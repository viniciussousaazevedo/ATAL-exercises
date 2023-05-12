package exerciseList01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutations {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        if (n == 1) {
            System.out.println(1);
        } else if (n < 4) {
            System.out.println("NO SOLUTION");
        } else {
            List<Integer> values = new ArrayList<>();

            for (int evenValue = 2; evenValue <= n; evenValue += 2) {
                values.add(evenValue);
            }

            for (int oddValue = 1; oddValue <= n; oddValue += 2) {
                values.add(oddValue);
            }

            StringBuilder stringValues = new StringBuilder();
            for (int value : values) {
                stringValues.append(value).append(" ");
            }
            System.out.println(stringValues.toString().trim());
        }
    }
}

