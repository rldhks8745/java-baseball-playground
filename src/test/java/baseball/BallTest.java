package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    void compareTest() {
        Ball computer = new Ball(0, 1);
        assertThat(computer.compare(new Ball(1, 1))).isEqualTo(BallStatus.BALL);
        assertThat(computer.compare(new Ball(0, 1))).isEqualTo(BallStatus.STIKE);
        assertThat(computer.compare(new Ball(0, 2))).isEqualTo(BallStatus.NOTHING);
    }
}
