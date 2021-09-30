package baseball.view;

import baseball.domain.BaseballNumbers;
import nextstep.utils.Console;

public class InputView {
    public BaseballNumbers userNumbers(){
        System.out.print("숫자를 입력해주세요 : ");
        return new BaseballNumbers(Console.readLine());
    }

    public boolean isContinue(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine().equals("1");
    }
}
