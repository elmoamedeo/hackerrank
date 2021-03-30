package Extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratedNumbers {

    /*
        Retorne uma lista de inteiros, contendo as seguintes regras:
        - Quantidade de dígitos respeite "numberSize"
        - Maior dígito deverá ser "maxDigit"
        - Soma dos dígitos do número deverá ser "sumOfNumber"
        - Não precisa considerar número inválido, por ex: "00032"
        - Caso nenhum número seja possível, o retorno deverá ser uma lista vazia
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
