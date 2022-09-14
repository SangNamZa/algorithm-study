/*
캐시
LRU 알고리즘을 사용한 캐시로
hit면 1
miss면 5의 시간이 소요된다.
가장 오래된 것을 표시할땐 그냥 시간을 써보자

5   jeju
10  jeju    pangyo
15  jeju    pangyo  seoul
20  pangyo  seoul   newyork
25  seoul   newyork la
30  newyork la      jeju
35  la      jeju    pangyo
40  jeju    pangyo  seoul
45  pangyo  seoul   newyork
50  seoul   newyork la
 */

import java.util.HashMap;
import java.util.Map;

public class Cache {
    public static void main(String[] args) {
        Cache cache = new Cache();
        int solution = cache.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println("solution = " + solution);
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        Map<String, Integer> cacheMap = new HashMap<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cacheMap.containsKey(city)) { // hit
                answer += 1;
                cacheMap.put(city, i); // 현재 index로 업데이트
            } else { // miss
                answer += 5;
                if (cacheMap.size() < cacheSize) { // cache에 빈공간이 있으면
                    cacheMap.put(city, i); // 현재 index로 입력
                } else { // 빈공간이 없으면
                    String minCity = getMinCity(cacheMap, i); // cache에서 가장 작은 것 찾기
                    cacheMap.remove(minCity);
                    cacheMap.put(city, i);
                }
            }
        }
        return answer;
    }

    private String getMinCity(Map<String, Integer> cacheMap, int i) {
        String minCity = "";
        Integer minTime = i;
        for (String key : cacheMap.keySet()) {
            Integer value = cacheMap.get(key);
            if (value < minTime) {
                minCity = key;
                minTime = value;
            }
        }
        return minCity;
    }
}
