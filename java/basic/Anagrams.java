package java.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        String lowerCaseA = a.toLowerCase();
        String lowerCaseB = b.toLowerCase();

        char tempArrayA[] = lowerCaseA.toCharArray();
        char tempArrayB[] = lowerCaseB.toCharArray();

        Arrays.sort(tempArrayA);
        Arrays.sort(tempArrayB);

        return Arrays.equals(tempArrayA, tempArrayB);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
