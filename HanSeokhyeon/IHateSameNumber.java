/*
같은 숫자는 싫어
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IHateSameNumber {
    public static void main(String[] args) {
        IHateSameNumber iHateSameNumber = new IHateSameNumber();
        int[] solution = iHateSameNumber.solution(new int[]{1,1,3,3,0,1,1});
        System.out.println("solution = " + Arrays.toString(solution));
    }
    
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) {
            if (answer.size() == 0) {
                answer.add(i);
                continue;
            }
            if (answer.get(answer.size()-1) != i) {
                answer.add(i);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
