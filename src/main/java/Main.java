import baseball.InputView;
import calculator.StringCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
          doBaseball();
    }

    public static void doCalculator() throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(str + " = ");
        System.out.println(new StringCalculator(str).parse().calc());
    }

    public static void doBaseball() {
        InputView iv = new InputView(System.in);
    }
}
