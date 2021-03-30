package java.introduction;

import java.util.Scanner;

public class StaticInitializerBlock {

    static Scanner input = new Scanner(System.in);
    static int b = input.nextInt();
    static int h = input.nextInt();
    static boolean flag = true;

    static {
        try {
            if (b <= 0 || h <= 0) {
                flag = false;
                throw new Exception("Breadth and height must be positive");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        if(flag) {
            int area = b * h;
            System.out.print(area);
        }
    }
}
