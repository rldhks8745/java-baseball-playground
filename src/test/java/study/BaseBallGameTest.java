package study;

import baseball.BaseBallGameCore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class BaseBallGameTest {
    @ParameterizedTest
    @CsvSource({
            "845,낫싱",
            "891,1볼",
            "137,포볼",
            "123,1볼 1스트라이크",
            "723,2스트라이크",
            "713,3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    })
    void baseBallGameCoreTest(String input, String expected) throws Exception {
        BaseBallGameCore bbgc = new BaseBallGameCore("713");
        bbgc.calc(input);

        assertThat(bbgc.getStatus()).contains(expected);
    }

    @Test
    void baseBallGameCoreExceptionTest() throws Exception {
        Throwable thr = catchThrowable(() -> new BaseBallGameCore("71"));

        assertThat(thr).hasMessageContaining("적어도 3자리 이상의 길이를 입력해 주십시오.");
    }

    @Test
    void baseBallGameCoreStrikeExceptionTest() throws Exception {
        BaseBallGameCore bbgc = new BaseBallGameCore("713");
        Throwable thr = catchThrowable(() -> bbgc.strike("12"));

        assertThat(thr).hasMessageContaining("입력한 값의 길이와 정답의 길이가 다릅니다.");
    }
}
