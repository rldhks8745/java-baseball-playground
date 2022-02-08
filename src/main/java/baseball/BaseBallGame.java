package baseball;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseBallGame extends BaseBallGameCore {

    final private InputView input;
    final private ResultView output;

    private static String generateAnswer(int numberSize) {
        Set<String> numbers = new HashSet<>();
        while(numbers.size() < numberSize) {
            numbers.add(String.valueOf((int)(Math.random() * 9) + 1));
        }

        return numbers.stream().collect(Collectors.joining());
    }

    public BaseBallGame(int numberSize) throws Exception {
        this(new InputView(System.in), new ResultView(System.out), numberSize);
    }

    public BaseBallGame(InputView input, ResultView output, int numberSize) throws Exception {
        super((BaseBallGame.generateAnswer(numberSize)));

        this.input = input;
        this.output = output;
    }

    public void startGame() {
        do {
            start();

            showResult();
        } while (restart());
    }

    private void start() {
        while(!isStrike(input())) {
            showResult();
        }
    }

    private boolean isStrike(String inputNumber) {
        try {
            return !strike(inputNumber);
        } catch (Exception e) {
            output.show(e.getMessage());
            return false;
        }
    }

    private String input() {
        return input.readLineWithQuestion("숫자를 입력해 주세요 : ");
    }

    private void showResult() {
        output.show(getStatus());
    }

    private boolean restart() {
        if ("2".equals(input.readLineWithQuestion("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")))
            return false;

        return true;
    }
}
