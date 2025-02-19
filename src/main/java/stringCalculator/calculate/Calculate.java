package stringCalculator.calculate;

import java.util.List;

public class Calculate {

    private static final AddOperation addOperation = new AddOperation();
    private static final DivideOperation divideOperation = new DivideOperation();
    private static final MultiplyOperation multiplyOperation = new MultiplyOperation();
    private static final SubtractOperation subtractOperation = new SubtractOperation();

    public int calculate(List<String> numbers, List<String> operators) {

        int result = Integer.parseInt(numbers.get(0));

        for(int i = 0; i < operators.size(); i++) {

            String operator = operators.get(i);

            if(operator.equals("+"))
                result = addOperation.calculate(result, Integer.parseInt(numbers.get(i+1)));
            else if(operator.equals("-"))
                result = subtractOperation.calculate(result, Integer.parseInt(numbers.get(i+1)));
            else if(operator.equals("*"))
                result = multiplyOperation.calculate(result, Integer.parseInt(numbers.get(i+1)));
            else
                result = divideOperation.calculate(result, Integer.parseInt(numbers.get(i+1)));
        }

        return result;
    }
}
