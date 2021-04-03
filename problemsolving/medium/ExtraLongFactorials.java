package problemsolving.medium;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

    static void extraLongFactorials(int n) {
        BigInteger bigInt = BigInteger.valueOf(1);
        while (n > 0) {
            bigInt = bigInt.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(bigInt);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
