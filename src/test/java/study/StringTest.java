package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @DisplayName("1,2를 split 하면 1과 2로 분리되어야 한다.")
    @Test
    void split1() {
        String orgStr = "1,2";
        assertThat(orgStr.split(",")).containsExactly("1", "2");
    }

    @DisplayName("1을 split 하면 1을 포함해야한다.")
    @Test
    void split2() {
        String orgStr = "1";
        assertThat(orgStr.split(",")).contains("1");
    }

    @DisplayName("(1,2)에서 괄호를 제거한 결과가 나와야한다.")
    @Test
    void substring() {
        String orgStr = "(1,2)";
        assertThat(orgStr.substring(1, orgStr.length() - 1)).isEqualTo("1,2");
    }

    @DisplayName("특정 위치에 해당하는 문자를 가져와야한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:a", "2:b", "3:c"}, delimiter = ':')
    void charAt(int index, char singleStr) {
        String orgStr = "abc";
        assertThat(orgStr.charAt(index - 1)).isEqualTo(singleStr);
    }

    @DisplayName("문자열 범위를 벗어나면 에러가 발생한다.")
    @Test
    void charAt_error() {
        String orgStr = "abc";
        assertThatThrownBy(() -> orgStr.charAt(orgStr.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
