package Java;

import java.util.Scanner;

public class LoopsII {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int res = a;

            for (int k = 0; k < n; k++) {
                res = res + b * (int) Math.pow(2, k);
                System.out.print(res + " ");
            }

            System.out.print("\n");
        }

        in.close();
    }
}
