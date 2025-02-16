package stringCalculator.calculate;

import stringCalculator.exception.ExceptionHandler;

public class DivideOperation implements Operation{
    @Override
    public int calculate(int a, int b) {

        if(b <= 0)
            ExceptionHandler.validateDivision(b);

        return a / b;
    }
}
