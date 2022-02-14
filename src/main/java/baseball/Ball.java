package baseball;

public class Ball {

    int position;
    int num;

    public Ball(int position, int num) {
        this.position = position;
        this.num = num;
    }

    boolean validateNumber() {
        return num >= 1 && num <= 9;
    }
}
