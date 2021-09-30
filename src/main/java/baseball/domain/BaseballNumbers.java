package baseball.domain;

import nextstep.utils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbers {
    private static final int SIZE = 3;

    private List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(String numberStr) {
        this(Arrays.stream(numberStr.split(""))
                .map(str -> new BaseballNumber(Integer.parseInt(str)))
                .collect(Collectors.toList()));
    }

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public BaseballNumbers() {
        Set<BaseballNumber> computerNumbers = new HashSet<>();
        while (computerNumbers.size() < SIZE) {
            computerNumbers.add(new BaseballNumber(Randoms.pickNumberInRange(1, 9)));
        }
        this.baseballNumbers = new ArrayList<>(computerNumbers);
    }

    private void validate(List<BaseballNumber> baseballNumbers) {
        Set<BaseballNumber> setNumbers = new HashSet<>(baseballNumbers);
        if (setNumbers.size() != SIZE) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요");
        }
    }

    public boolean isEnd(BaseballNumbers userNumbers) {
        return strikeCount(userNumbers) == 3;
    }

    public boolean isNothing(BaseballNumbers userNumbers) {
        return strikeCount(userNumbers) == 0 && ballCount(userNumbers) == 0;
    }

    public boolean hasStrike(BaseballNumbers userNumbers) {
        return strikeCount(userNumbers) != 0;
    }

    public int strikeCount(BaseballNumbers userNumbers) {
        return (int) IntStream.range(0, userNumbers.size())
                .filter(i -> isStrike(i, userNumbers.getBaseballNumbers().get(i)))
                .count();
    }

    public boolean hasBall(BaseballNumbers userNumbers) {
        return ballCount(userNumbers) != 0;
    }

    public int ballCount(BaseballNumbers userNumbers) {
        return (int) IntStream.range(0, userNumbers.size())
                .filter(i -> isBall(i, userNumbers.getBaseballNumbers().get(i)))
                .count();
    }

    private boolean isStrike(int index, BaseballNumber number) {
        return baseballNumbers.get(index).equals(number);
    }

    private boolean isBall(int index, BaseballNumber number) {
        return !isStrike(index, number) && baseballNumbers.contains(number);
    }

    public List<BaseballNumber> getBaseballNumbers() {
        return baseballNumbers;
    }

    public int size() {
        return baseballNumbers.size();
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
