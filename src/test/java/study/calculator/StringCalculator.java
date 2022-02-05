package study.calculator;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.ValidationException;
import java.util.*;

public class StringCalculator {
    private String[] values;
    private Deque<Integer> numberStack = new LinkedList<>();
    private Deque<String> operationStack = new LinkedList<>();

    public StringCalculator(String str) throws Throwable {
        if (isEmpty(str))
            throw new Exception("빈 문자열 입니다.");

        this.values = str.split(" ");
        parse();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private void parse() throws ValidationException {
        for(String v : values){
            discriminateAndPush(v);
        };
        validate();
    }

    private void discriminateAndPush(String v) throws ValidationException {
        try {
            numberStack.push(Integer.parseInt(v));
            validateOrderAfterPushingNumber();
        } catch (NumberFormatException nfe) {
            operationStack.push(v);
            validateOrderAfterPushingOperation();
        }
    }

    private void validateOrderAfterPushingNumber() throws ValidationException {
        if (numberStack.size() - 1 != operationStack.size())
            throwValidationException();
    }

    private void validateOrderAfterPushingOperation() throws ValidationException {
        if (operationStack.size() != numberStack.size())
            throwValidationException();
    }

    private void throwValidationException() throws ValidationException {
        throw new ValidationException("계산식이 순서가 잘못되었습니다.");
    }

    private void validate() throws ValidationException {
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
