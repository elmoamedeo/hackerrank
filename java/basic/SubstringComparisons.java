package java.basic;

import java.util.Scanner;

public class SubstringComparisons {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        java.util.List<String> arrayList = new java.util.ArrayList<>();

        for (int i = 0; i < s.length() - k + 1; i++) {
            arrayList.add(s.substring(i, i + k));
        }

        java.util.Collections.sort(arrayList);

        smallest = arrayList.get(0);
        largest = arrayList.get(arrayList.size() - 1);

        return smallest + "\n" + largest;
    }

}
