package stringCalculator.view;

import stringCalculator.exception.ExceptionHandler;

import java.util.Scanner;

public class InputView {

    public String[] inputString() {
        OutputView.printCalculationMessage();
        System.out.println("숫자와 연산자 사이를 공백으로 구분하며 계산식을 입력해주세요.");

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        checkBlankInput(value);
        checkSyntax(value);

        return value.split(" ");
    }

    private void checkBlankInput(String value) {
        ExceptionHandler.validateExpression(value);
    }

    private void checkSyntax(String value) {
        ExceptionHandler.validateSyntax(value);
    }
}
