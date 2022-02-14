package baseball;

public class BallNumber {
    int number;

    public BallNumber(int number) {
        this.number = number;
    }

    boolean validateNumber() {
        return number >= 1 && number <= 9;
    }
}
