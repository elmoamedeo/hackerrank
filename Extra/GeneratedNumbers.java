package Extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratedNumbers {

    /*
        Method must return a list of integers, containing the following rules:
        - Number of digits has to respect "numberSize"
        - Largest digit should be less than "maxDigit"
        - Sum of the number digits of every value in array should be "sumOfNumber"
        - You do not need to consider an invalid number, eg "00032"
        - If no number is possible, the return must be an empty list
     */
    static List<Integer> generateIntListWithMaxNumber(int maxDigit, int numberSize, int sumOfDigits) {
        List<Integer> integerList = new ArrayList<>();

        int i = 0;
        while (String.valueOf(i).length() <= numberSize) {
            if (sumOfDigitsIsEqualToParam(i, sumOfDigits)) {
                if (String.valueOf(i).length() == numberSize) {
                    if (!hasSpecificDigitOrHigher(i, maxDigit)) {
                        integerList.add(i);
                    }
                }
            }
            i++;
        }

        return integerList;
    }

    private static boolean sumOfDigitsIsEqualToParam(int num, int sumOfDigits) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum == sumOfDigits;
    }

    private static boolean hasSpecificDigitOrHigher(int num, int maxDigit) {
        while (num > 0) {
            if (num % 10 >= maxDigit) {
                return true;
            }

            num /= 10;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxDigit = scan.nextInt();
        int numberSize = scan.nextInt();
        int sumOfDigits = scan.nextInt();
        System.out.println(generateIntListWithMaxNumber(maxDigit, numberSize, sumOfDigits));
        scan.close();
    }

}
