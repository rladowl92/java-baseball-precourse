package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
    @Test
    void create() {
        BaseballNumber baseballNumber = new BaseballNumber(1);
        assertThat(baseballNumber).isEqualTo(new BaseballNumber(1));
    }

    @DisplayName("1-9 범위 밖의 숫자 입력시 오류")
    @ParameterizedTest
    @ValueSource(ints = {0,10})
    void error(int number) {
        assertThatThrownBy(() -> new BaseballNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1-9까지 숫자만 입력 가능합니다.");
    }
}