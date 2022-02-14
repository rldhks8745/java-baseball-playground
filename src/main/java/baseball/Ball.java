package baseball;

import java.util.Objects;

public class Ball {

    int position;
    BallNumber ballNumber;

    public Ball(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = new BallNumber(ballNumber);

        if (!this.ballNumber.validateNumber())
            throw new RuntimeException("숫자의 범위가 1 ~ 9를 넘습니다.");
    }

    public BallStatus compare(Ball other) {
        if (this.equals(other))
            return BallStatus.STIKE;

        if (this.ballNumber == other.ballNumber)
            return BallStatus.BALL;

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
