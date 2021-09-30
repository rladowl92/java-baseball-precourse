package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
    @Test
    void create() {
        BaseballNumbers baseballNumbers = new BaseballNumbers("123");
        assertThat(baseballNumbers).isEqualTo(new BaseballNumbers("123"));
    }

    @DisplayName("3자리 숫자가 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"})
    void error(String numberStr) {
        assertThatThrownBy(() -> new BaseballNumbers(numberStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자를 입력해주세요");
    }
}