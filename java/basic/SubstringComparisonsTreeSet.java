package java.basic;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class SubstringComparisonsTreeSet {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        // Solution using TreeSet, which isn't possible on the platform because the imports are fixed
        String smallest = "";
        String largest = "";

        SortedSet<String> sets = new TreeSet<>();

        for (int i=0; i<= s.length()-k; i++){
            sets.add(s.substring(i, i+k));
        }

        smallest = sets.first();
        largest = sets.last();

        return smallest + "\n" + largest;
    }

}
