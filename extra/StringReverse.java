package extra;

import java.util.Scanner;

public class StringReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(stringReverseLazyWay(s));
        System.out.println(stringReverseRootsWay(s));
        scanner.close();
    }

    static String stringReverseLazyWay(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static String stringReverseRootsWay(String s) {
        char[] input = s.toCharArray();
        int start = 0;
        int end = input.length - 1;
        char tempString;
        while (end > start) {
            tempString = input[start];
            input[start] = input[end];
            input[end] = tempString;
            end--;
            start++;
        }
        return new String(input);
    }
}
