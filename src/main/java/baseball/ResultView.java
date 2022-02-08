package baseball;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class ResultView {
    private PrintStream out;

    public ResultView(PrintStream out) {
        this.out = out;
    }

    public void show(String result) {
        out.println(result);
    }
}
