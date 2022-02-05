package study.calculator;

import javax.naming.OperationNotSupportedException;

public class Calculator {
    private int n1;
    private int n2;
    private String operation;

    public Calculator(int n1, int n2, String operation) {
        this.n1 = n1;
        this.n2 = n2;
        this.operation = operation;
    }

    public int calc() throws OperationNotSupportedException {
        if ("+".equals(operation))
            return add();
        if ("-".equals(operation))
            return subtract();
        if ("*".equals(operation))
            return multiply();
        if ("/".equals(operation))
            return divide();

        throw new OperationNotSupportedException("지원하지않는 operation 입니다.");
    }

    private int add() { return n1 + n2; }
    private int subtract() { return n1 - n2; }
    private int multiply() { return n1 * n2; }
    private int divide() { return n1 / n2; }
}
