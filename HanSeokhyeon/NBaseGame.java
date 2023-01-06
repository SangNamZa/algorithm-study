/*
n진수 게임

n진수로 나열해서 순서를 찾는 게임
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NBaseGame {

    public static void main(String[] args) {
        NBaseGame nBaseGame = new NBaseGame();
//        String solution = nBaseGame.solution(2, 4, 2, 1);
        String solution = nBaseGame.solution(16, 16, 2, 2);
        System.out.println("solution = " + solution);
    }

    public String solution(int n, int t, int m, int p) {
        List<String> list = getNeededStrings(n, t, m, p); // 0, 1, 1, 0, 1, 1, 1, 0, 0, …
        return getAnswer(t, m, p, list); // "0111"
    }

    private String getAnswer(int t, int m, int p, List<String> list) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i % m == p - 1) { // 본인 순서
                answer.append(list.get(i));
            }
            if (answer.length() == t) { // t만큼 쌓였으면 for문 탈출
                break;
            }
        }

        return answer.toString();
    }

    private List<String> getNeededStrings(int n, int t, int m, int p) {
        List<String> list = new ArrayList<>();
        list.add("0");
        int nowValue = 1;
        while (list.size() < t * m * p) {
            List<String> nBase = getNBase(n, nowValue);
            list.addAll(nBase);
            nowValue++;
        }
        return list;
    }

    private List<String> getNBase(int n, int nowValue) {
        String[] alphabets = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        List<String> list = new ArrayList<>();
        while (nowValue >= 1) {
            list.add(alphabets[nowValue % n]);
            nowValue /= n;
        }
        Collections.reverse(list);
        return list;
    }
}
