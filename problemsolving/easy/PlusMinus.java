package problemsolving.easy;

import java.util.Scanner;

public class PlusMinus {

    static void plusMinus(int[] arr) {
        double positives = 0;
        double negatives = 0;
        double zeroes = 0;

        for (int i : arr) {
            if (i > 0) {
                positives++;
            } else if (i < 0) {
                negatives++;
            } else {
                zeroes++;
            }
        }

        System.out.printf("%.6f\n", (float)positives/arr.length);
        System.out.printf("%.6f\n", (float)negatives/arr.length);
        System.out.printf("%.6f\n", (float)zeroes/arr.length);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}