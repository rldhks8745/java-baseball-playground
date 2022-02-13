package study;

import calculator.StringCalculator;
import exception.ValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import javax.naming.OperationNotSupportedException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1 + 2,3",
            "3 * 5,15",
            "10 / 5,2",
            "2 + 3 * 4 / 2,10",
            "5,5"
    })
    @DisplayName("문자열로 들어온 계산식 테스트")
    void execute(String str, int expectedResult) throws Throwable {
        assertThat(new StringCalculator(str).parse().calc()).isEqualTo(expectedResult);
    }

    static Stream<Arguments> exceptionTestParameters() {
        return Stream.of(
                Arguments.of("2 & 3", OperationNotSupportedException.class, "지원하지않는 operation 입니다."),
                Arguments.of("2 ! 3", OperationNotSupportedException.class, "지원하지않는 operation 입니다."),
                Arguments.of("2 +", ValidationException.class, "계산식이 잘못되었습니다."),
                Arguments.of("2 - 3 *", ValidationException.class, "계산식이 잘못되었습니다."),
                Arguments.of("", Exception.class, "빈 문자열 입니다."),
                Arguments.of("+", ValidationException.class, "계산식이 순서가 잘못되었습니다."),
                Arguments.of("1 1 *", ValidationException.class, "계산식이 순서가 잘못되었습니다.")
        );
    }

    @ParameterizedTest(name ="{index}: {0}, {2}")
    @MethodSource("exceptionTestParameters")
    @DisplayName("예외 테스트")
    void executeException(String str, Class<Throwable> expectedExceptionClass, String errorMessage) {
        Throwable thr = catchThrowable(() -> new StringCalculator(str).parse().calc());
        assertThat(thr).isInstanceOf(expectedExceptionClass)
                .hasMessageContaining(errorMessage);
    }
}
