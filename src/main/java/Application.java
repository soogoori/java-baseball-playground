import baseball.utils.CheckResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import stringCalculator.calculate.Calculate;
import stringCalculator.utils.StringParser;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        CheckResult checkResult = new CheckResult();

        // 게임 루프 시작
        runGameLoop(inputView, checkResult);
    }

    private static void runGameLoop(InputView inputView, CheckResult checkResult) {
        boolean keepPlaying = true;

        while (keepPlaying) {
            // 게임 시작
            startGame(inputView, checkResult);

            // 게임이 끝난 후, 다시 시작할지 여부 확인
            String playGame = inputView.inputPlayGame();
            keepPlaying = playGame.equals("1");  // "1"을 입력하면 게임을 다시 시작
        }

        OutputView.printEndGameMessage();
    }

    private static void startGame(InputView inputView, CheckResult checkResult) {

        // 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
        String realNum = inputView.generateThreeUniqueNumbers();

        String result;

        do {
            // 숫자 입력 받기
            String num = inputView.inputNum();

            // 숫자 게임 결과 확인
            Map<String, Integer> strike = checkResult.isStrike(num, realNum);
            Map<String, Integer> ball = checkResult.isBall(num, realNum);

            result = OutputView.printResult(strike, ball);

            // 결과 출력
            System.out.println(result);

        } while (!result.equals("3스트라이크"));

        // 3스트라이크 맞히면 게임 종료 메시지 출력
        OutputView.printCorrectMessage();
    }

    /*public static void main(String[] args){

        InputView inputView = new InputView();
        Calculate calc = new Calculate();

        // 계산식 입력받기
        String[] value = inputView.inputString();

        Map<String, List<String>> resultMap = StringParser.parseString(value);

        // 계산식 파싱
        List<String> numbers =  resultMap.get("numbers");
        List<String> operators = resultMap.get("operators");

        // 계산하기
        int result = calc.calculate(numbers, operators);

        // 계산결과 출력하기
        OutputView.printResultMessage(result);
    }*/
}
