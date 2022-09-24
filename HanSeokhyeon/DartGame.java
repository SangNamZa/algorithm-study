/*
다트게임

점수|보너스|[옵션] 순으로 주어진다.
점수 0-10
보너스
    S : 1제곱
    D : 2제곱
    T : 3제곱
옵션
    * : 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
    # : 해당 점수는 마이너스가 된다.
 */

import java.util.ArrayList;
import java.util.List;

public class DartGame {

    public static void main(String[] args) {
        DartGame dartGame = new DartGame();
        int solution = dartGame.solution("1S2D*3T");
        System.out.println("solution = " + solution);
        int solution2 = dartGame.solution("1D2S3T*");
        System.out.println("solution = " + solution2);
    }

    public int solution(String dartResult) {
        int i = 0;
        List<Integer> scoreList = new ArrayList<>();
        while (i < dartResult.length()) {

            // 점수
            int score = dartResult.charAt(i++) - '0';
            if (dartResult.charAt(i) == '0') { // 다음 문자가 0이면
                score = 10; // 점수는 10
                i++;
            }

            // 보너스
            char bonus = dartResult.charAt(i++);
            if (bonus == 'D') {
                score *= score; // 2제곱
            } else if (bonus == 'T') {
                score *= score * score; // 3제곱
            }
            if (i == dartResult.length()) { // 뒤에 더이상 문자가 없으면 끝
                scoreList.add(score);
                break;
            }

            // 옵션
            if (dartResult.charAt(i) == '*') {
                if (scoreList.size() > 0) { // 이전 점수가 있으면
                    scoreList.set(scoreList.size() - 1, scoreList.get(scoreList.size() - 1) * 2); // 2배로 만들어주기
                }
                score *= 2; // 현재 점수 2배
                i++;
            } else if (dartResult.charAt(i) == '#') {
                score *= -1; // 현재 점수 -1배
                i++;
            }

            // 점수 리스트에 추가
            scoreList.add(score);
        }
        return scoreList.stream().mapToInt(Integer::intValue).sum(); // sum
    }
}
