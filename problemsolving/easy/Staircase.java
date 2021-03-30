package problemsolving.easy;

import java.util.Scanner;

public class Staircase {

    static void staircase(int stepQty) {
        int stairSpaces, stairSteps;
        int counter = 0;
        for (int stairSize = 0; stairSize < stepQty; stairSize++) {
            counter++;

            for (stairSpaces = stepQty - 1; stairSpaces > stairSize; stairSpaces--) {
                System.out.print(" ");
            }

            for (stairSteps = 0; stairSteps <= counter - 1; stairSteps++) {
                System.out.print("#");
            }

            System.out.print("\n");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
