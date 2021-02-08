package Java;

import java.util.Scanner;

public class LoopsI {

    private static void mult(int number) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d \n", number, i, number * i);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        mult(N);

        scanner.close();
    }
}
