# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구 사항
* 기본적으로 1부터 9까지 서로 다른수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  * [예] 상대방(컴퓨터)의 수가 425일 때
    * 123을 제시한 경우: 1스트라이크
    * 456을 제시한 경우: 1스트라이크 1볼
    * 789를 제시한 경우: 낫싱
* 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

## 기능 목록
* baseballNumber
  * 1-9까지 숫자로 validation
* baseballNumbers
  * baseballNumber list
  * 생성자로 숫자 전달
    * integer로 입력받아서 baseballNuber set으로 변환
    * 컴퓨터 수는 랜덤 생성한 값으로 전달
    * 플레이어 수는 사용자 입력값으로 전달
  * 3자리 숫자인지 validation : set 자료형 활용
  * isStrike : 자리와 숫자가 동일한 경우 true
  * isBall : 자리는 다르지만 숫자가 동일한 경우 true
  * strikeCount : isStrike를 반복하여 개수 반환
  * ballCount : isBall을 반복하여 개수 반환
* 입출력 view 및 어플리케이션 추가

