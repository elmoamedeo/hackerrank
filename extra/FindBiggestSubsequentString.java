package extra;

import java.util.Scanner;

public class FindBiggestSubsequentString {

    /*
        Given two string a and b, find the length of longest subsequence of string a which is substring in sequence b.
        Example: in(abcd, abdc) out(3).

        Either of the string cannot be bigger than final int MAX_LENGTH.
     */
    public static int findLengthOfTheLongestSubsequence(String a, String b) {
        // Length of both strings for further usage
        int firstStringLength = a.length(), secondStringLength = b.length();

        // Var that defines the biggest size possible for either string
        final int MAX_LENGTH = 5000;

        // Creates a 2D array
        int[][] twoDArray = new int[MAX_LENGTH][MAX_LENGTH];

        // Initialize the 2D array to 0
        for (int i = 0; i <= secondStringLength; i++) {
            for (int j = 0; j <= firstStringLength; j++) {
                twoDArray[i][j] = 0;
            }
        }

        // Calculating value for each element of the string
        for (int i = 1; i <= secondStringLength; i++) {
            for (int j = 1; j <= firstStringLength; j++) {
                // If alphabet of string a and b are equal make twoDArray[i][j] = 1 + twoDArray[i-1][j-1]
                if (a.charAt(j - 1) == b.charAt(i - 1)) {
                    twoDArray[i][j] = 1 + twoDArray[i - 1][j - 1];
                }
                // Else copy the previous value in the row i.e twoDArray[i-1][j-1]
                else {
                    twoDArray[i][j] = twoDArray[i][j - 1];
                }
            }
        }

        int maxLen = 0;

        // Finding the maximum length
        for (int i = 1; i <= secondStringLength; i++) {
            maxLen = Math.max(maxLen, twoDArray[i][firstStringLength]);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstString = scan.next();
        String secondString = scan.next();
        System.out.println(findLengthOfTheLongestSubsequence(firstString, secondString));
        scan.close();
    }
}
