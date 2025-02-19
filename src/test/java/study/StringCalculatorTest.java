package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringCalculator.calculate.*;
import stringCalculator.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @DisplayName("올바른 연산자 입력 테스트")
    @Test
    void InputView_inputString_연산자_입력_테스트() {

        // given
        InputView inputView = new InputView();
        String input = "2 + 4 / 2 - 1 * 4";

        InputStream systemIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(systemIn);

        // when
        String[] value = inputView.inputString();

        // then
        assertThat(value).hasSize(9);
        assertThat(value).containsExactly("2", "+", "4", "/", "2", "-", "1", "*", "4");
    }
    @DisplayName("덧셈 연산자 계산 테스트")
    @Test
    void AddOperation_덧셈_연산_테스트() {

        // given
        AddOperation addOperation = new AddOperation();

        // when
        int result = addOperation.calculate(2, 4);

        // then
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("뺄셈 연산자 계산 테스트")
    @Test
    void SubtractOperation_뺄셈_연산_테스트() {

        // given
        SubtractOperation subtractOperation = new SubtractOperation();

        // when
        int result = subtractOperation.calculate(2, 4);

        // then
        assertThat(result).isEqualTo(-2);
    }

    @DisplayName("곱셈 연산자 계산 테스트")
    @Test
    void MultiplyOperation_곱셈_연산_테스트() {

        // given
        MultiplyOperation multiplyOperation = new MultiplyOperation();

        // when
        int result = multiplyOperation.calculate(2, 4);

        // then
        assertThat(result).isEqualTo(8);
    }
    @DisplayName("나눗셈 연산자 계산 테스트")
    @Test
    void DivideOperation_나눗셈_연산_테스트() {

        // given
        DivideOperation divideOperation = new DivideOperation();

        // when
        int result = divideOperation.calculate(9, 4);

        // then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("나눗셈 연산자 예외처리 테스트")
    @Test
    void DivideOperation_나눗셈_연산_예외처리_테스트() {

        // given
        DivideOperation divideOperation = new DivideOperation();

        // when & then
        assertThrows(ArithmeticException.class, () -> divideOperation.calculate(6, 0));
    }

    @DisplayName("계산 테스트")
    @Test
    void CalculateTest() {

        // given
        Calculate calculate = new Calculate();
        List<String> numbers = List.of("1", "4", "3");
        List<String> operators = List.of("*", "-");

        // when
        int result = calculate.calculate(numbers, operators);

        // then
        assertThat(result).isEqualTo(1);
    }
}
