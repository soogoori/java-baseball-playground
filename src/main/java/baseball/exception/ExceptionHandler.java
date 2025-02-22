package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class ExceptionHandler {

    // 입력한 숫자가 1부터 9까지 서로 다른 수로 이루어진 3자리의 수가 아닌 경우 예외 처리
    public static boolean isValidThreeDigitNumber(String value) {
        Set<Character> uniqueDigits = new HashSet<>();

        for(char c : value.toCharArray()) {
            uniqueDigits.add(c);
        }

        if(value.length() !=3 || value.contains("0") || uniqueDigits.size() != 3) {
            System.out.println("유효하지 않은 숫자입니다. 숫자를 다시 입력하세요");
            return false;
        }

        return true;
    }
}
