package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
    @DisplayName("직접 숫자를 입력해서 생성")
    @Test
    void create_user() {
        BaseballNumbers baseballNumbers = new BaseballNumbers("123");
        assertThat(baseballNumbers).isEqualTo(new BaseballNumbers("123"));
    }

    @DisplayName("자동 생성")
    @Test
    void create_computer() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        assertThat(baseballNumbers.size()).isEqualTo(3);
    }

    @DisplayName("3자리 숫자가 아니면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234"})
    void error(String numberStr) {
        assertThatThrownBy(() -> new BaseballNumbers(numberStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자를 입력해주세요");
    }

    @DisplayName("strike 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"123:3", "124:2", "145:1", "456:0"}, delimiter = ':')
    void strikeCount(String userStr, int count) {
        BaseballNumbers computerNumbers = new BaseballNumbers("123");
        BaseballNumbers userNumbers = new BaseballNumbers(userStr);
        assertThat(computerNumbers.strikeCount(userNumbers)).isEqualTo(count);
    }

    @DisplayName("ball 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"312:3", "314:2", "345:1", "456:0", "123:0"}, delimiter = ':')
    void ballCount(String userStr, int count) {
        BaseballNumbers computerNumbers = new BaseballNumbers("123");
        BaseballNumbers userNumbers = new BaseballNumbers(userStr);
        assertThat(computerNumbers.ballCount(userNumbers)).isEqualTo(count);
    }

    @DisplayName("nothing 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"456:true", "123:false", "156:false"}, delimiter = ':')
    void isNothing(String userStr, boolean result) {
        BaseballNumbers baseballNumbers = new BaseballNumbers("123");
        BaseballNumbers userNumbers = new BaseballNumbers(userStr);
        assertThat(baseballNumbers.isNothing(userNumbers)).isEqualTo(result);
    }

    @DisplayName("strike 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"123:true", "156:true", "231:false", "456:false"}, delimiter = ':')
    void hasStrike(String userStr, boolean result) {
        BaseballNumbers baseballNumbers = new BaseballNumbers("123");
        BaseballNumbers userNumbers = new BaseballNumbers(userStr);
        assertThat(baseballNumbers.hasStrike(userNumbers)).isEqualTo(result);
    }

    @DisplayName("ball 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"312:true", "134:true", "123:false", "456:false"}, delimiter = ':')
    void hasBall(String userStr, boolean result) {
        BaseballNumbers baseballNumbers = new BaseballNumbers("123");
        BaseballNumbers userNumbers = new BaseballNumbers(userStr);
        assertThat(baseballNumbers.hasBall(userNumbers)).isEqualTo(result);
    }
}