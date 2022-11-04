import java.util.*;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        DoublePriorityQueue doublePriorityQueue = new DoublePriorityQueue();
//        int[] solution = doublePriorityQueue.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
//        int[] solution = doublePriorityQueue.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        int[] solution = doublePriorityQueue.solution(new String[]{"I 1", "I 0", "D 1"});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(String[] operations) {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (String operationString : operations) {
            StringTokenizer stringTokenizer = new StringTokenizer(operationString);
            String operation = stringTokenizer.nextToken();
            int value = Integer.parseInt(stringTokenizer.nextToken());
            if ("D".equals(operation) && min.size() < 1)
                continue;

            if ("I".equals(operation)) {
                min.add(value);
                max.add(value);
                continue;
            }

            if (value < 0) {
                Integer minValue = min.poll();
                max.remove(minValue);
                continue;
            }

            Integer maxValue = max.poll();
            min.remove(maxValue);
        }
        if (min.size() == 0) {
            return new int[]{0, 0};
        }
        return new int[]{max.remove(), min.remove()};
    }
}
