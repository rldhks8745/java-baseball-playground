#기능 요구 사항
### 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

Ball

- BallPosition position
- BallNumber num
  - [ ✔ ] 1 ~ 9 숫자범위
    - BallNumber.validateNumber

Balls
- [ ✔ ] 3자릿수
  - Balls.validateLength
- [ ✔ ] 3가지 숫자는 서로 다른 수
  - Balls.hasSameNumber

### 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱
- 같은 수, 같은 자리 : 스트라이크
- 같은 수, 다른 자리 : 볼
- 없으면 낫싱

Balls <-> Balls
Balls <-> Ball
Ball <-> Ball

1. [ ✔ ] Ball끼리 비교 Ball.compare, 스트라이크, 볼, 낫싱 상태 반환
2. [ ✔ ] Balls <-> Ball 비교 Balls.compareBallsAndBall
3. [ ✔ ] Balls끼리 비교 Balls.compareBetweenBalls



### 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 랜덤 3가지
  - BallUtil.generateBalls

### 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.

### 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.