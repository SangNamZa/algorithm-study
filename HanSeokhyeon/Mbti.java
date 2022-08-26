/*
5점인데 NA면 +5 AN이면 -5 부여
4가지 점수에 대해 각각 모두 계산후
부호를 보고 MBTI를 결정
"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
 */

import java.util.HashMap;

public class Mbti {
    public static void main(String[] args) {
        Mbti mbti = new Mbti();
        String solution = mbti.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        System.out.println(solution);
    }

    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> map = initMap();
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) {
                String key = Character.toString(survey[i].charAt(1));
                Integer integer = map.get(key);
                map.put(key, integer + (choices[i]-4));
            } else if (choices[i] < 4) {
                String key = Character.toString(survey[i].charAt(0));
                Integer integer = map.get(key);
                map.put(key, integer - (choices[i]-4));
            }
        }
        StringBuilder answer = new StringBuilder();
        String[][] mbti = new String[][]{{"R", "T"}, {"F", "C"}, {"M", "J"}, {"A", "N"}};
        for (String[] characters : mbti) {
            Integer score1 = map.get(characters[0]);
            Integer score2 = map.get(characters[1]);
            if (score1 > score2) {
                answer.append(characters[0]);
            } else if (score1 < score2) {
                answer.append(characters[1]);
            } else {
                answer.append((characters[0].compareTo(characters[1]) < 0) ? characters[0] : characters[1]);
            }
        }
        return answer.toString();
    }

    private HashMap<String, Integer> initMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        return map;
    }
}
