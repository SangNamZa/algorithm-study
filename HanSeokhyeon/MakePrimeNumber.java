/*
소수 만들기
주어진 수들중 3개를 골라서 더해서 몇개의 소수를 만들 수 있는지
1. 주어진 수들로 3개를 고르는 경우를 찾고
2. 소수인지 아닌지 판단
 */


public class MakePrimeNumber {
    private int answer = 0;

    public static void main(String[] args) {
        MakePrimeNumber makePrimeNumber = new MakePrimeNumber();
        int solution = makePrimeNumber.solution(new int[]{1, 2, 3, 4});
        System.out.println("solution = " + solution);
    }

    public int solution(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        combination(nums, visited, 0, 3);
        return answer;
    }

    private void combination(int[] nums, boolean[] visited, int start, int choose) {
        if (choose == 0) {
            int sum = getSum(nums, visited);
            checkPrimeNumber(sum);
            return;
        }
        if (start == nums.length) {
            return;
        } else {
            visited[start] = true;
            combination(nums, visited, start+1, choose-1);
            visited[start] = false;
            combination(nums, visited, start+1, choose);
        }
    }

    private void checkPrimeNumber(int sum) {
        for (int i = 2; i < sum / 2; i++) {
            if (sum % i == 0) {
                return;
            }
        }
        answer += 1;
    }

    private int getSum(int[] nums, boolean[] visited) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                result += nums[i];
            }
        }
        return result;
    }
}
