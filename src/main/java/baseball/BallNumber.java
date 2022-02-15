package baseball;

import java.util.Objects;

public class BallNumber {
    private final int number;

    public BallNumber(int number) {
        if (!validateNumber(number))
            throw new RuntimeException("숫자의 범위가 1 ~ 9를 넘습니다.");
        this.number = number;
    }

    public static boolean validateNumber(int number) {
        return number >= 1 && number <= 9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
