package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    @Test
    void test1_1() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1");
        assertThat(actual).contains("1", "2");
        assertThat(actual).containsExactly("1", "2");
        assertThat(actual[1]).isEqualTo("2");
        assertThat(actual.length).isEqualTo(2);
    }

    @Test
    void test1_2() {
        String[] actual = "1".split(",");
        assertThat(actual.length).isEqualTo(1);
        assertThat(actual[0]).isEqualTo("1");
        assertThat(actual).contains("1");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void test2() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열의 특정 위치의 문자를 반환한다. 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외가 발생한다.")
    void test3() {
        String abc = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> abc.charAt(6))
                .withMessageMatching("String index out of range: 6");
    }
}
