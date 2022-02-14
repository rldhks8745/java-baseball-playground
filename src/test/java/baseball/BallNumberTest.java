package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallNumberTest {

    @Test
    @DisplayName("숫자위 1 ~ 9 검증 테스트")
    void validateNumberTest() {
        assertThat(new BallNumber(1).validateNumber()).isTrue();
        assertThat(new BallNumber(9).validateNumber()).isTrue();
        assertThat(new BallNumber(0).validateNumber()).isFalse();
        assertThat(new BallNumber(10).validateNumber()).isFalse();
    }
}
