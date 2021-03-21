package Java.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramsWithMapAndVerifications {

    // Solution inspired by 'coderator'
    static boolean isAnagram(String a, String b) {
        // Checking if the inputs are null and/or empty, and throwing an Exception if that's the case
        if (a == null || b == null || a.equals("") || b.equals("")) {
            throw new IllegalArgumentException();
        }

        // Checking for the length of the 2 strings since there's no way of the 2 word being anagrams if they are different in size
        if (a.length() != b.length()) {
            return false;
        }

        String lowerCaseA = a.toLowerCase();
        String lowerCaseB = b.toLowerCase();

        // Populating the map with the letters and frequencies of string b
        Map<Character, Integer> map = new HashMap<>();

        for (int k = 0; k < lowerCaseB.length(); k++) {
            char letter = lowerCaseB.charAt(k);

            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                Integer frequency = map.get(letter);
                map.put(letter, ++frequency);
            }
        }

        // Test each letter in String a against the data in the map, return if letter ir absent otherwise decrease frequency by 1
        for (int k = 0; k < lowerCaseA.length(); k++) {
            char letter = lowerCaseA.charAt(k);

            if (!map.containsKey(letter))
                return false;

            Integer frequency = map.get(letter);

            if (frequency == 0)
                return false;
            else
                map.put(letter, --frequency);
        }
        // If the code has passed all the previous stages it has to be an Anagram
        return true;
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
