package stringCalculator.utils;

import stringCalculator.exception.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringParser {

    public static Map<String, List<String>> parseString (String[] value) {
        List<String> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for(String str : value) {
            if(str.matches("-?\\d+")) {
                numbers.add(str);
            } else if (str.matches("[+\\-*/]")) {
                operators.add(str);
            }
        }

        ExceptionHandler.validateOperators(numbers, operators);

        Map<String, List<String>> resultMap = new HashMap<>();
        resultMap.put("numbers", numbers);
        resultMap.put("operators", operators);

        return resultMap;
    }
}
