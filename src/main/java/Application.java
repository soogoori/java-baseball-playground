import stringCalculator.calculate.Calculate;
import stringCalculator.utils.StringParser;
import stringCalculator.view.InputView;
import stringCalculator.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args){

        InputView inputView = new InputView();

        // 계산식 입력받기
        String[] value = inputView.inputString();

        Map<String, List<String>> resultMap = StringParser.parseString(value);

        // 계산식 파싱
        List<String> numbers =  resultMap.get("numbers");
        List<String> operators = resultMap.get("operators");

        // 계산하기
        int result = Calculate.calculate(numbers, operators);

        // 계산결과 출력하기
        OutputView.printResultMessage(result);
    }
}
