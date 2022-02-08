package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BaseBallGameCore {

    private String answer;
    protected int ball = 0;
    protected int strike = 0;

    public BaseBallGameCore(String answer) throws Exception {
        if (!validateLength(answer))
            throw new Exception("적어도 3자리 이상의 길이를 입력해 주십시오.");

        this.answer = answer;
    }

    private boolean validateLength(String answer) {
        return answer != null && answer.length() >= 3;
    }

    public boolean strike(String input) throws Exception {
        if (answer.length() != input.length())
            throw new Exception("입력한 값의 길이와 정답의 길이가 다릅니다.");

        resetStatus();

        if (answer.equals(input)) {
            strike = answer.length();
            return true;
        }

        calc(input);

        return false;
    }

    private void resetStatus() {
        ball = 0;
        strike = 0;
    }

    public void calc(String input) {        
        for(int i=0; i<input.length(); i++) {
            calcStrikeAndBall(input.charAt(i), i);
        }
    }

    private void calcStrikeAndBall(char input, int index) {
        if(calcStrike(input, index)) {
            strike++;
            return;
        }

        if(calcBall(input, index)) {
            ball++;
            return;
        }
    }

    private boolean calcStrike(char input, int index) {
        return equals(input, answer.charAt(index));
    }

    private boolean equals(char c1, int c2) {
        return c1 == c2;
    }

    private boolean calcBall(char input, int index) {
        return Stream.of(remains(index).split(""))
                .map(s -> s.charAt(0))
                .filter(c -> c == input)
                .count() > 0;
    }

    private String remains(int index) {
        return answer.substring(0, index) + answer.substring(index + 1);
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();

        if(ball == answer.length())
            return "포볼";

        if(strike == answer.length())
            return String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", strike);

        if(ball > 0)
            sb.append(ball + "볼 ");

        if(strike > 0)
            sb.append(strike + "스트라이크");

        if(sb.length() <= 0)
            return "낫싱";

        return sb.toString();
    }
}
