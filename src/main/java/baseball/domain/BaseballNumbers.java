package baseball.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumbers {
    private static final int SIZE = 3;

    private Set<BaseballNumber> baseballNumbers;

    public BaseballNumbers(Set<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }
        this.baseballNumbers = baseballNumbers;
    }

    public BaseballNumbers(String numberStr) {
        this(Arrays.stream(numberStr.split(""))
                .map(str -> new BaseballNumber(Integer.parseInt(str)))
                .collect(Collectors.toSet()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumbers that = (BaseballNumbers) o;
        return Objects.equals(baseballNumbers, that.baseballNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseballNumbers);
    }
}
