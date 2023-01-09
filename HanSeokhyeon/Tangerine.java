/*
귤 고르기

k개를 골라 한 상자에 담을 예정
종류가 최소가 되게
최소인 종류를 리턴

존재하는 귤의 종류를 조사
가장 적은 귤부터 제거해가면서 k에 도달하면 종료
 */

import java.util.*;
import java.util.stream.Collectors;

public class Tangerine {

    public static void main(String[] args) {
        Tangerine tangerine = new Tangerine();
        int solution = tangerine.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
//        int solution = tangerine.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
//        int solution = tangerine.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});
        System.out.println("solution = " + solution);
    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = getTangerineCountMap(tangerine); // { 1: 1, 2: 2, 3: 2, 4: 1, 5: 2 }
        Map<Integer, Integer> count = getTangerineKeyCountMap(map); // { 1: 2, 2: 3 }
        List<Integer> list = count.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); // [ 2, 1 ]

        int tangerineCount = 0;
        int answer = 0;
        for (Integer i : list) {
            for (int j = 0; j < count.get(i); j++) {
                if (tangerineCount >= k) { // k개 이상 수집
                    return answer;
                }
                tangerineCount += i;
                answer++;
            }
        }
        return answer;
    }

    private Map<Integer, Integer> getTangerineKeyCountMap(Map<Integer, Integer> map) {
        Map<Integer, Integer> count = new HashMap<>();
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (count.containsKey(value)) {
                count.put(value, count.get(value)+1);
            } else {
                count.put(value, 1);
            }
        }
        return count;
    }

    private Map<Integer, Integer> getTangerineCountMap(int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }
}
