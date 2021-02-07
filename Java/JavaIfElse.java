package Java;

import java.util.Scanner;

public class JavaIfElse {

    private static void weirdNumber(int n) {
        if (n % 2 == 0)
            if (n >= 2 && n <= 5)
                System.out.print("Not Weird");
            else if (n >= 6 && n <= 20)
                System.out.print("Weird");
            else if (n > 20)
                System.out.print("Not Weird");
            else
                System.out.print("Not Weird");
        else
            System.out.print("Weird");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        weirdNumber(N);

        scanner.close();
    }
}
