package baseball;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum BallStatus {
    BALL, NOTHING, STRIKE;

    public static Map<BallStatus, Integer> createBallStatusMap() {
        return Arrays.stream(BallStatus.values())
                .collect(Collectors.toMap(
                        ballStatus -> ballStatus,
                        ballStatus -> 0));
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
