package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] splitedString = "1,2".split(",");
        assertThat(splitedString).contains("1", "2");

        splitedString = "1".split(",");
        assertThat(splitedString).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        str = str.substring(0, str.length() - 1);
        str = str.substring(1);

        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 테스트")
    void charAt() {
        // given

        // when
        Throwable thrown = catchThrowable(() -> "abc".charAt(3));

        // then
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 3");
    }
}
