package exerciseList02;

import java.util.Scanner;

class DroppingBalls {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testsNumber = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testsNumber; i++) {
            String[] input = sc.nextLine().split(" ");
            System.out.println(droppingBalls(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        sc.nextInt();
    }

    private static int droppingBalls(int depth, int ballNum) {
        int output = 1;
        for (int i = 1; i < depth; i++) {
            if (ballNum % 2 == 1) {
                output *= 2;
                ballNum++;
            } else {
                output = 2 * output + 1;
            }
            ballNum /= 2;
        }
        return output;
    }
}
