import stringCalculator.utils.StringParser;
import stringCalculator.view.InputView;

public class Application {
    public static void main(String[] args){

        // 계산식 입력받기
        String value = InputView.inputString();

        // 계산식 파싱
        StringParser.parseString(value);
    }
}
