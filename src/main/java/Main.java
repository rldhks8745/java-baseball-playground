import calculator.StringCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(str + "= ");
        System.out.println(new StringCalculator(str).parse().calc());
    }
}
