package baseball.domain;

import java.util.Objects;

public class BaseballNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private int value;

    BaseballNumber(int value){
        if(value < MIN_NUMBER || value > MAX_NUMBER){
            throw new IllegalArgumentException("1-9까지 숫자만 입력 가능합니다.");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
