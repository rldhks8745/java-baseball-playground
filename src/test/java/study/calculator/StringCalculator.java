package study.calculator;

import javax.naming.OperationNotSupportedException;
import javax.xml.bind.ValidationException;
import java.util.Deque;
import java.util.LinkedList;

public class StringCalculator {
    private final String str;
    private final Deque<Integer> numberStack = new LinkedList<>();
    private final Deque<String> operationStack = new LinkedList<>();

    protected class ParsedStringCalculator {
        private final Deque<Integer> numberStack;
        private final Deque<String> operationStack;

        public ParsedStringCalculator(Deque<Integer> numberStack, Deque<String> operationStack) {
            this.numberStack = numberStack;
            this.operationStack = operationStack;
        }

        public int calc() throws OperationNotSupportedException {
            while(!operationStack.isEmpty()) {
                numberStack.offerLast(new Calculator(numberStack.pollLast(), numberStack.pollLast(), operationStack.pollLast()).calc());
            }

            return numberStack.pollLast();
        }
    }

    /**
     *
     * @param str
     * @throws Exception
     */
    public StringCalculator(String str) throws Exception {
        if (isEmpty(str))
            throw new Exception("빈 문자열 입니다.");

        this.str = str;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public ParsedStringCalculator parse() throws ValidationException {
        for(String v : str.split(" ")){
            discriminateAndPush(v);
        }
        validate();

        return new ParsedStringCalculator(numberStack, operationStack);
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
}
