/*
타겟 넘버

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

DFS로 depth만큼 가보고 결과값이 target과 같으면 answer++
 */

public class TargetNumber {

    private int answer = 0;
    private int[] numbers;
    private int target;

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
//        int solution = targetNumber.solution(new int[]{1, 1, 1, 1, 1}, 3);
        int solution = targetNumber.solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }

    private void dfs(int depth, int value) {
        if (depth == numbers.length) {
            if (value == target) {
                answer++;
            }
            return;
        }
        dfs(depth+1, value+numbers[depth]);
        dfs(depth+1, value-numbers[depth]);
    }
}
