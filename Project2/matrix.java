package Project2;

import java.util.Scanner;

public class matrix{
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a num1: ");
        int num = sc.nextInt();

        System.out.print("Enter a num2:");
        int num2 = sc.nextInt();

        System.out.println("Addition is " + (num+num2));
        sc.close();
    }

}
