package baseball;

import java.util.Objects;

public class Ball {

    private final BallPosition ballPosition;
    private final BallNumber ballNumber;

    public Ball(int ballPosition, int ballNumber) {
        this.ballPosition = new BallPosition(ballPosition);
        this.ballNumber = new BallNumber(ballNumber);
    }

    public BallStatus compare(Ball other) {
        if (this.equals(other))
            return BallStatus.STRIKE;

        if (this.ballNumber.equals(other.ballNumber))
            return BallStatus.BALL;

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballPosition, ball.ballPosition) && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballPosition, ballNumber);
    }
}
