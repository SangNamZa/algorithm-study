/*
영어 끝말잇기

끝말잇기하다가
걸리는 사람 번호, 걸린 번째 리턴
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EnglishWordChainGame {

    public static void main(String[] args) {
        EnglishWordChainGame englishWordChainGame = new EnglishWordChainGame();
        int[] solution = englishWordChainGame.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i]) // 이미 말한 단어
                    || (i > 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))) { // 연결되지 않는 단어
                return new int[]{i % n + 1, i / n + 1}; // 나머지 + 1, 몫 + 1
            }
            map.put(words[i], 0);
        }
        return new int[2]; // [0, 0]
    }
}
