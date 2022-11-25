/*
튜플

"{{1,2,3},{2,1},{1,2,4,3},{2}}" -> [2, 1, 3, 4]
 */

import java.util.*;

public class Tuple {

    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        int[] solution = tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(String s) { // {{1,2,3},{2,1},{1,2,4,3},{2}}
        List<Integer> list = new ArrayList<>(); // 결과 저장용
        Map<Integer, Integer> map = new HashMap<>(); // 존재하는지 확인용
        s = s.substring(2, s.length()-2); // 1,2,3},{2,1},{1,2,4,3},{2
        String[] strings = s.split("},\\{"); // ["1,2,3", "2,1", "1,2,4,3", "2"]
        Arrays.sort(strings, Comparator.comparingInt(String::length)); // ["2", "2,1", "1,2,3", "1,2,4,3"]
        for (String string : strings) {
            String[] split = string.split(","); // ["2", "1"]
            for (String s1 : split) {
                int i = Integer.parseInt(s1); // 1
                if (!map.containsKey(i)){ // {2: 0}
                    list.add(i); // [2, 1]
                    map.put(i, 0); // {2: 0, 1: 0}
                }
            }
        }
        return list.stream().mapToInt(Integer::new).toArray(); // [2, 1, 4, 3]
    }
}
