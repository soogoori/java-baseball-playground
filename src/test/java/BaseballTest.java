import baseball.exception.ExceptionHandler;
import baseball.utils.CheckResult;
import baseball.view.OutputView;
import org.junit.jupiter.api.Test;


import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseballTest {

    @Test
    void 유효한_숫자_확인_테스트() {
        // given
        String num = "2334335";

        // when
        boolean isValid = ExceptionHandler.isValidThreeDigitNumber(num);

        // then
        assertThat(isValid).isFalse();
    }

    @Test
    void 스트라이크_테스트() {
        // given
        CheckResult checkResult = new CheckResult();

        // when
        String inputNum = "352";
        String realNum = "345";
        Map<String, Integer> strike = checkResult.isStrike(inputNum, realNum);

        // then
        assertThat(strike.get("스트라이크")).isEqualTo(1);
    }

    @Test
    void 볼_테스트() {
        // given
        CheckResult checkResult = new CheckResult();

        // when
        String inputNum = "352";
        String realNum = "345";
        Map<String, Integer> ball = checkResult.isBall(inputNum, realNum);

        // then
        assertThat(ball.get("볼")).isEqualTo(1);
    }

    @Test
    void 결과_테스트() {
        // given
        CheckResult checkResult = new CheckResult();

        String inputNum = "352";
        String realNum = "345";
        Map<String, Integer> ball = checkResult.isBall(inputNum, realNum);
        Map<String, Integer> strike = checkResult.isStrike(inputNum, realNum);

        // when
        String result = OutputView.printResult(strike, ball);

        // then
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

}
