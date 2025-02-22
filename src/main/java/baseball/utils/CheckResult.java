package baseball.utils;

import java.util.HashMap;
import java.util.Map;

public class CheckResult {

    // 같은 수가 같은 자리에 있으면 스트라이크
    public Map<String, Integer> isStrike(String inputNum, String realNum) {

        Map<String, Integer> strikeInfo = new HashMap<>();

        int strike = 0;

        for(int i=0; i<3; i++) {
            strike += calculateStrike(inputNum.charAt(i), realNum.charAt(i));
        }

        strikeInfo.put("스트라이크", strike);

        return strikeInfo;
    }

    // 다른 자리에 있으면 볼
    public Map<String, Integer> isBall(String inputNum, String realNum) {

        Map<String, Integer> ballInfo = new HashMap<>();

        int ball = 0;

        for(int i=0; i<3; i++) {
            ball += calculateBall(inputNum.charAt(i), realNum.charAt(i), realNum);
        }

        ballInfo.put("볼", ball);

        return ballInfo;
    }

    // 같은 수가 전혀 없으면 포볼
    public String is4Ball(String inputNum, String realNum) {
        int ball = 0;

        for(int i=0; i<3; i++) {
            ball += calculate4Ball(inputNum.charAt(i), realNum);
        }

        if(ball==3) return "nothing";

        return "";
    }

    private int calculateStrike(char inputChar, char realChar) {
        if(inputChar == realChar) return 1;
        return 0;
    }

    private int calculateBall(char inputChar, char realChar, String realNum) {
        if((inputChar != realChar) && (realNum.contains(String.valueOf(inputChar)))) return 1;
        return 0;
    }

    private int calculate4Ball(char inputChar, String realNum) {
        if(!realNum.contains(String.valueOf(inputChar))) return 1;
        return 0;
    }
}
