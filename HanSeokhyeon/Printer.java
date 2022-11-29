import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    public static void main(String[] args) {
        Printer printer = new Printer();
        int solution = printer.solution(new int[]{2, 1, 3, 2}, 2);
//        int solution = printer.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] priorities, int location) {

        Queue<Document> queue = initQueue(priorities, location);

        int index = priorities.length - 1;
        Arrays.sort(priorities);

        int answer = 1;
        while (!queue.isEmpty()) {
            Document document = queue.remove(); // queue에서 하나 꺼내고
            if (priorities[index] == document.priority) { // 현재 document의 priority가 제일 크고
                if (document.target) { // 타겟이라면
                    return answer; // 종료
                } else { // 타겟이 아니면 프린트되고 끝이므로
                    answer++; // 순서가 하나 올라가고
                    index--; // 그다음 우선순위로 지정
                }
            } else { // priority가 가장 크지 않으면 
                queue.add(document); // 다시 queue에 넣기
            }
        }
        return answer;
    }

    private Queue<Document> initQueue(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Document(priorities[i], i == location));
        }
        return queue;
    }

    static class Document {
        Integer priority;
        Boolean target;

        public Document(Integer priority, Boolean target) {
            this.priority = priority;
            this.target = target;
        }
    }
}
