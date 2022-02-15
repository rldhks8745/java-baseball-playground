package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallNumberTest {

    @Test
    @DisplayName("숫자위 1 ~ 9 검증 테스트")
    void validateNumberTest() {
        assertThat(BallNumber.validateNumber(1)).isTrue();
        assertThat(BallNumber.validateNumber(9)).isTrue();
        assertThat(BallNumber.validateNumber(0)).isFalse();
        assertThat(BallNumber.validateNumber(10)).isFalse();
    }
}
