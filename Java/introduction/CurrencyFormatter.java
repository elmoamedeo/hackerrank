package Java.introduction;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        Locale usLocale = Locale.getDefault();
        // We have to create Locale f/ India
        Locale indLocale = new Locale("en", "IN");
        Locale chiLocale = Locale.CHINA;
        Locale fraLocale = Locale.FRANCE;

        NumberFormat currFormatterUs = NumberFormat.getCurrencyInstance(usLocale);
        NumberFormat currFormatterInd = NumberFormat.getCurrencyInstance(indLocale);
        NumberFormat currFormatterChi = NumberFormat.getCurrencyInstance(chiLocale);
        NumberFormat currFormatterFra = NumberFormat.getCurrencyInstance(fraLocale);

        System.out.println("US: " + currFormatterUs.format(payment));
        System.out.println("India: " + currFormatterInd.format(payment));
        System.out.println("China: " + currFormatterChi.format(payment));
        System.out.println("France: " + currFormatterFra.format(payment));
    }
}
