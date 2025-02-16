package stringCalculator.exception;

import java.util.List;

public class ExceptionHandler {

    // 계산식이 비어 있는 경우 예외 처리
    public static void validateExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("계산식을 입력해야 합니다.");
        }
    }

    // 비정상적인 계산식(연산자로 시작/끝나는 경우) 예외 처리
    public static void validateSyntax(String expression) {
        if (expression.matches("^[+*/].*") || expression.matches(".*[+\\-*/]$")) {
            throw new IllegalArgumentException("계산식이 연산자로 시작하거나 끝날 수 없습니다.");
        }
    }

    // 비정상적인 계산식 (연산자의 개수가 숫자의 개수보다 크거나 같을 때) 예외 처리
    public static void validateOperators(List<String> numbers, List<String> operators) {
        if(numbers.size() <= operators.size())
            throw new IllegalArgumentException("계산식의 연산자의 개수가 피연산자의 개수보다 크거나 같을 수 없습니다.");
    }

    // 나눗셈 시 음수 또는 0이 입력된 경우 예외 처리
    public static void validateDivision(int divisor) {
        if (divisor <= 0) {
            throw new IllegalArgumentException("나눗셈의 분모는 0 또는 음수가 될 수 없습니다.");
        }
    }
}
