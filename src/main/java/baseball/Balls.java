package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> balls) {
        if (!validateLength(balls))
            throw new RuntimeException("숫자는 3자릿수만 가능합니다.");
        if (hasSameNumber(balls))
            throw new RuntimeException("같은 숫자가 중복될 수 없습니다.");
        this.balls = createBalls(balls);
    }

    public static boolean validateLength(List<Integer> balls) {
        return balls.size() == 3;
    }

    public static boolean hasSameNumber(List<Integer> balls) {
        return new HashSet<>(balls).size() != balls.size();
    }

    private List<Ball> createBalls(List<Integer> balls) {
        List<Ball> result = new ArrayList<>();
        for (int position=0; position<balls.size(); position++) {
            result.add(new Ball(position, balls.get(position)));
        }
        return result;
    }

    public BallStatus compareBallsAndBall(Ball otherBall) {
        return balls.stream().map((ball) -> ball.compare(otherBall))
                .filter((status) -> status.isStrike() || status.isBall())
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public String compareBetweenBalls(Balls otherBalls) {
        BallScore ballScore = new BallScore();
        for (Ball otherBall : otherBalls.balls) {
            ballScore.setScore(this.compareBallsAndBall(otherBall));
        }
        return ballScore.toString();
    }
}
