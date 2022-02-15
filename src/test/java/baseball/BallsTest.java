package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void validateLengthTest() {
        assertThat(Balls.validateLength(Arrays.asList(1, 2, 3))).isTrue();
    }

    @Test
    void hasSameNumberTest() {
        assertThat(Balls.hasSameNumber(Arrays.asList(1,2,3))).isFalse();
        assertThat(Balls.hasSameNumber(Arrays.asList(1,2,2))).isTrue();
        assertThat(Balls.hasSameNumber(Arrays.asList(1,2,1))).isTrue();
    }

    @Test
    void compareBallsTest() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        assertThat(computer.compareBallsAndBall(new Ball(0, 1))).isEqualTo(BallStatus.STRIKE);
        assertThat(computer.compareBallsAndBall(new Ball(2, 1))).isEqualTo(BallStatus.BALL);
        assertThat(computer.compareBallsAndBall(new Ball(0, 4))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void compareBetweenBallsTest() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        assertThat(computer.compareBetweenBalls(new Balls(Arrays.asList(4, 5, 6)))).isEqualTo("낫싱");
        assertThat(computer.compareBetweenBalls(new Balls(Arrays.asList(1, 5, 6)))).isEqualTo("1 스트라이크");
        assertThat(computer.compareBetweenBalls(new Balls(Arrays.asList(2, 5, 6)))).isEqualTo("1 볼");
        assertThat(computer.compareBetweenBalls(new Balls(Arrays.asList(2, 1, 3)))).isEqualTo("1 스트라이크 2 볼");
        assertThat(computer.compareBetweenBalls(new Balls(Arrays.asList(1, 2, 3)))).isEqualTo("3 스트라이크");
    }
}
