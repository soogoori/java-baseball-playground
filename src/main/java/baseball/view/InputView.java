package baseball.view;

import baseball.exception.ExceptionHandler;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String inputNum() {

        String num = getInput();

        while(!checkInputNum(num)){
            num = getInput();
        }

        return num;
    }

    // 1에서 9까지 서로 다른 임의의 수 3개를 선택
    public String generateThreeUniqueNumbers() {

        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < 3) {
            int num = random.nextInt(9) + 1; // 1~9 사이의 랜덤 숫자
            numbers.add(num);
        }

        return getRealNumber(numbers);
    }

    // 숫자 입력받기
    private String getInput() {
        OutputView.printInputMessage();
        return scanner.nextLine();
    }

    // 유효한 숫자 입력했는지 확인 (1부터 9까지 서로 다른 수로 이루어진 3자리의 수인지 확인)
    private boolean checkInputNum(String value) {
        return ExceptionHandler.isValidThreeDigitNumber(value);
    }

    private String getRealNumber(Set<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }
}
