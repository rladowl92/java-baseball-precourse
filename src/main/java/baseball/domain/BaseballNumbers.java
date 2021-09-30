package baseball.domain;

import nextstep.utils.Randoms;

import java.util.*;

public class BaseballNumbers {
    private static final int SIZE = 3;

    private List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(String numberStr) {
        List<BaseballNumber> baseballNumbers = new ArrayList<>();
        for(String i: numberStr.split("")){
            baseballNumbers.add(new BaseballNumber(Integer.parseInt(i)));
        }
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

    public boolean hasBall(BaseballNumbers userNumbers) {
        return ballCount(userNumbers) != 0;
    }

    public int strikeCount(BaseballNumbers userNumbers) {
        int count = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            count += isStrike(i, userNumbers.getBaseballNumbers().get(i));
        }
        return count;
    }

    public int ballCount(BaseballNumbers userNumbers) {
        int count = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            count += isBall(i, userNumbers.getBaseballNumbers().get(i));
        }
        return count;
    }

    private int isStrike(int index, BaseballNumber number) {
        if (baseballNumbers.get(index).equals(number)) {
            return 1;
        }
        return 0;
    }

    private int isBall(int index, BaseballNumber number) {
        if (isStrike(index, number) == 0 && baseballNumbers.contains(number)) {
            return 1;
        }
        return 0;
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
