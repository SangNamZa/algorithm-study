/*
구명보트

무게제한을 넘지 않게 태워야하고
최소한으로 배를 사용해서 구하고 싶다.
 */

import java.util.Arrays;

public class Lifeboat {
    public static void main(String[] args) {
        Lifeboat lifeboat = new Lifeboat();
        int solution = lifeboat.solution(new int[]{70, 50, 80, 50}, 100);
        System.out.println("solution = " + solution);
        solution = lifeboat.solution(new int[]{70, 80, 50}, 100);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] weights = Arrays.stream(people).sorted().toArray();
        int start = 0; int end = people.length-1;
        while (start <= end) {
            int weightSum = weights[end--]; // 제일 무거운거 하나 싣고
            while (weightSum + weights[start] <= limit) { // 더이상 안들어갈 때 까지
                weightSum += weights[start++]; // 가벼운거 계속 싣기
            }
            answer++;
        }
        return answer;
    }
}
