package baseball.view;

import java.util.Map;

public class OutputView {

    public static void printInputMessage() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void printCorrectMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printEndGameMessage() {
        System.out.println("게임을 종료합니다.");
    }

    public static String printResult(Map<String, Integer> strike, Map<String, Integer> ball) {

        int strikes = strike.get("스트라이크");
        int balls = ball.get("볼");

        if(strikes > 0 && balls > 0 ){
            String ballResult = balls + "볼";
            String strikeResult = strikes + "스트라이크";

            return ballResult + " " + strikeResult;
        }

        if(balls > 0 && strikes == 0) return balls + "볼";
        if(strikes > 0 && balls == 0) return strikes + "스트라이크";

        return "nothing";
    }
}
