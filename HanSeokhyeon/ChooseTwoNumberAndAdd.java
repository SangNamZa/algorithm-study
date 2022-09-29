import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChooseTwoNumberAndAdd {
    public static void main(String[] args) {
        ChooseTwoNumberAndAdd chooseTwoNumberAndAdd = new ChooseTwoNumberAndAdd();
        int[] solution = chooseTwoNumberAndAdd.solution(new int[]{2, 1, 3, 4, 1});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int number = numbers[i] + numbers[j];
                if (!map.containsKey(number)) {
                    map.put(number, 0);
                }
            }
        }
        return map.keySet().stream().mapToInt(i -> i).sorted().toArray();
    }
}
