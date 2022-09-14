/*
폰켓몬
N/2마리를 가져갈 수 있는데
최대한 다른 종류로 가져갈 수 있는 수를 리턴

먼저 map으로 다 정리하고
key수가 N/2보다 크면 N/2 작으면 key수 리턴
 */

import java.util.HashMap;
import java.util.Map;

public class Ponkemon {

    public static void main(String[] args) {
        Ponkemon ponkemon = new Ponkemon();
        int solution = ponkemon.solution(new int[]{3, 3, 3, 2, 2, 4});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
        }
        return Math.min(map.size(), nums.length / 2);
    }
}
