/*
위장
옷을 서로 다르게 입어야한다.
머리 -> yellow_hat, green_turban, _
안경 -> blue_sunglasses, _
3 * 2 - 1 = 5
1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses

머리 -> 1, 2, 3, _
안경 -> 4, 5, _
바지 -> 6, 7, _
4 * 3 * 3 - 1 = 35

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Camouflage {
    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();
        int solution = camouflage.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(solution);
    }

    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            String value = clothe[0];
            List<String> values;
            if (map.containsKey(key)) {
                values = map.get(key);
            } else {
                values = new ArrayList<>();
            }
            values.add(value);
            map.put(key, values);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key).size()+1;
        }
        return answer - 1;
    }
}
