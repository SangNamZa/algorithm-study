import java.util.HashMap;
import java.util.Map;

public class NumberStringAndEnglishWord {
    public static void main(String[] args) {
        NumberStringAndEnglishWord numberStringAndEnglishWord = new NumberStringAndEnglishWord();
        int result = numberStringAndEnglishWord.solution("one4seveneight");
        System.out.println("result = " + result);
    }

    public int solution(String s) {
        Map<String, Integer> map = getStringIntegerMap(); // String -> Number init
        StringBuilder answer = new StringBuilder();
        while (s.length() > 0) { // 문자열이 남아있으면
            if (Character.isDigit(s.charAt(0))) { // 첫번째 글자가 숫자면
                answer.append(s.charAt(0)); // 첫번째 글자 추가
                s = s.substring(1); // 첫번째 글자 제거
                continue;
            }
            for (String numberString : map.keySet()) {
                if (s.startsWith(numberString)) { // one으로 시작한다면
                    answer.append(map.get(numberString)); // one 추가
                    s = s.substring(numberString.length()); // one 제거
                }
            }
        }
        return Integer.parseInt(answer.toString());
    }

    private Map<String, Integer> getStringIntegerMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        return map;
    }
}
