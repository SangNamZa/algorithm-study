import java.util.*;

public class NewsClustering {

    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();
//        int solution = newsClustering.solution("FRANCE", "french");
//        int solution = newsClustering.solution("FRANCE+", "french");
        int solution = newsClustering.solution("aa1+aa2", "AAAA12");
        System.out.println("solution = " + solution);
    }

    public int solution(String str1, String str2) {
        return calculate(preprocess(str1), preprocess(str2));
    }

    private Map<String, Integer> preprocess(String str1) {
        str1 = str1.toLowerCase(Locale.ROOT);
        return get2Characters(str1);
    }

    private int calculate(Map<String, Integer> str1List, Map<String, Integer> str2List) {
        Map<String, Integer> maxMap = getMaxMap(str1List);
        int min = 0;
        for (String key : str2List.keySet()) {
            if (maxMap.containsKey(key)) {
                Integer maxValue = maxMap.get(key);
                Integer nowValue = str2List.get(key);
                maxMap.put(key, Math.max(maxValue, nowValue));
            } else {
                maxMap.put(key, str2List.get(key));
            }

            if (str1List.containsKey(key)) {
                Integer minValue = str1List.get(key);
                Integer nowValue = str2List.get(key);
                min += Math.min(minValue, nowValue);
            }
        }
        int max = getMax(maxMap);
        if (max == 0) {
            return 65536;
        }
        return (int) ((float) min / max * 65536);
    }

    private int getMax(Map<String, Integer> maxMap) {
        int max = 0;
        for (String key : maxMap.keySet()) {
            max += maxMap.get(key);
        }
        return max;
    }

    private Map<String, Integer> getMaxMap(Map<String, Integer> str1List) {
        Map<String, Integer> maxMap = new HashMap<>();
        for (String key : str1List.keySet()) {
            maxMap.put(key, str1List.get(key));
        }
        return maxMap;
    }

    private Map<String, Integer> get2Characters(String str1) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length()-1; i++) {
            String s = str1.substring(i, i + 2);
            if (s.replaceAll("[^a-z]", "").length() != 2) {
                continue;
            }
            if (map.containsKey(s)) {
                map.put(s, map.get(s)+1);
            } else {
                map.put(s, 1);
            }
        }
        return map;
    }
}
