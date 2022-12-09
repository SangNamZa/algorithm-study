import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheNearestCharacter {

    public static void main(String[] args) {
        TheNearestCharacter theNearestCharacter = new TheNearestCharacter();
        int[] bananas = theNearestCharacter.solution("banana");
        System.out.println("bananas = " + Arrays.toString(bananas));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { // 이미 존재했던 문자면
                answer[i] = i - map.get(c); // 현재 인덱스 - 과거 인덱스
            } else { // 존재하지 않았다면
                answer[i] = -1; // -1로 입력
            }
            map.put(c, i); // 현재 인덱스로 업데이트
        }
        return answer;
    }
}
