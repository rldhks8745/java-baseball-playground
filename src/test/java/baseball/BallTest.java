package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    @DisplayName("숫자범우 1 ~ 9 검증 테스트")
    void validateNumberTest() {
        assertThat(new Ball(0, 1).validateNumber()).isTrue();
        assertThat(new Ball(0, 9).validateNumber()).isTrue();
        assertThat(new Ball(0, 0).validateNumber()).isFalse();
        assertThat(new Ball(0, 10).validateNumber()).isFalse();
    }
}
