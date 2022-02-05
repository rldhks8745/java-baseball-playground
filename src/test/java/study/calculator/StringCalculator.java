package study.calculator;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.ValidationException;
import java.util.*;

public class StringCalculator {
    private String[] values;
    private Deque<Integer> numberStack;
    private Deque<String> operationStack;

    public StringCalculator(String str) throws Throwable {
        if (isEmpty(str))
            throw new Exception("빈 문자열 입니다.");

        this.values = str.split(" ");
        this.numberStack = new LinkedList<>();
        this.operationStack = new LinkedList<>();

        divideAndPush();
        validate();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private void divideAndPush() {
        Arrays.asList(values).stream().forEach((v) -> {
            try {
                numberStack.push(Integer.parseInt(v));
            } catch (NumberFormatException nfe) {
                operationStack.push(v);
            }
        });
    }

    private void validate() throws Exception {
        if (numberStack.isEmpty())
            throw new ValueException("피연산자가 존재하지 않습니다.");
        if (operationStack.isEmpty())
            throw new ValueException("연산자가 존재하지 않습니다.");
        if (numberStack.size() - 1 != operationStack.size())
            throw new ValidationException("계산식이 잘못되었습니다.");
    }

    public int calc() throws OperationNotSupportedException {
        while(!operationStack.isEmpty()) {
            numberStack.offerLast(new Calculator(numberStack.pollLast(), numberStack.pollLast(), operationStack.pollLast()).calc());
        }

        return numberStack.pollLast();
    }
}
