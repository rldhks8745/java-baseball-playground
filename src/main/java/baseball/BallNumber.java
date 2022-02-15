package baseball;

import java.util.Objects;

public class BallNumber {
    private final int number;

    public BallNumber(int number) {
        this.number = number;
    }

    boolean validateNumber() {
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
