package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @DisplayName("1,2를 split 하면 1과 2로 분리되어야 한다.")
    @Test
    void split1() {
        String orgStr = "1,2";
        assertThat(orgStr.split(",")).containsExactly("1","2");
    }

    @DisplayName("1을 split 하면 1을 포함해야한다.")
    @Test
    void split2() {
        String orgStr = "1";
        assertThat(orgStr.split(",")).contains("1");
    }
}
