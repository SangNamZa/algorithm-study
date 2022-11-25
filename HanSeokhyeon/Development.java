import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Development {

    public static void main(String[] args) {
        Development development = new Development();
        int[] solution = development.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int deployDay = getDay(progresses, speeds, 0); // 남은 날짜 계산
        int dayCount = 1;
        for (int i = 1; i < progresses.length; i++) {
            int day = getDay(progresses, speeds, i); // 남은 날짜 계산
            if (day > deployDay) {
                result.add(dayCount);
                deployDay = day;
                dayCount = 1;
            } else {
                dayCount++;
            }
        }
        result.add(dayCount);
        return result.stream().mapToInt(Integer::new).toArray();
    }

    private int getDay(int[] progresses, int[] speeds, int x) {
        return (int) Math.ceil((double) (100 - progresses[x]) / speeds[x]);
    }
}
