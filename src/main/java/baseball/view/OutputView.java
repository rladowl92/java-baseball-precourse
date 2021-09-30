package baseball.view;

import baseball.domain.BaseballNumbers;

public class OutputView {
    public void printResult(BaseballNumbers computerNumbers, BaseballNumbers userNumbers) {
        if (computerNumbers.isNothing(userNumbers)) {
            System.out.println("nothing");
        }
        printHits(computerNumbers, userNumbers);
        System.out.println();
    }

    private void printHits(BaseballNumbers computerNumbers, BaseballNumbers userNumbers) {
        if (computerNumbers.hasStrike(userNumbers)) {
            System.out.printf("%d strike ", computerNumbers.strikeCount(userNumbers));
        }
        if (computerNumbers.hasBall(userNumbers)) {
            System.out.printf("%d ball", computerNumbers.ballCount(userNumbers));
        }
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}
