package java.introduction;

import java.util.Scanner;

public class EndOfFile {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = "";
        int numberOfLine = 1;

        while(input.hasNext()) {
            line = input.nextLine();
            System.out.println(numberOfLine + " " + line);
            numberOfLine++;
        }
    }
}
