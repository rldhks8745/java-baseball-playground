package baseball;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private Scanner sc;

    public InputView(InputStream in) {
        sc = new Scanner(in);
    }

    public InputView(String in) {
        sc = new Scanner(in);
    }

    public String readLineWithQuestion(String question) {
        System.out.print(question);
        return sc.nextLine();
    }
}
