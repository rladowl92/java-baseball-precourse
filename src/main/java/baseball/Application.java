package baseball;

import baseball.domain.BaseballNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        do {
            gamePlay();
        } while (inputView.isContinue());
    }

    private static void gamePlay() {
        BaseballNumbers computerNumbers = new BaseballNumbers();
        BaseballNumbers userNumbers;
        do {
            userNumbers = inputView.userNumbers();
            outputView.printResult(computerNumbers, userNumbers);
        } while (!computerNumbers.isEnd(userNumbers));
        outputView.printEndMessage();
    }
}
