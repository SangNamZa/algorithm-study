import java.util.Arrays;

public class NightOvertimeIndex {
    public static void main(String[] args) {
        NightOvertimeIndex nightOvertimeIndex = new NightOvertimeIndex();
        long solution = nightOvertimeIndex.solution(4, new int[]{4, 3, 3});
        System.out.println("solution = " + solution);
    }

    public long solution(int n, int[] works) {
        Arrays.sort(works); // 처음 정렬
        for (int i = 0; i < n; i++) {
            if (works[works.length-1] == 0) { // 정렬했으니 마지막 값이 0이면 모두 0
                return 0;
            }
            works[works.length-1] -= 1; // 1시간 야근
            for (int j = works.length-1; j > 0; j--) { // 다시 정렬
                if (works[j] < works[j-1]) { // 이전 element가 현재 element보다 작으면
                    swap(works, j-1, j); // swap
                } else { // 크면 끝
                    break;
                }
            }
        }
        return getPowSum(works); // 제곱합 계산
    }

    private long getPowSum(int[] works) {
        long answer = 0;
        for (int work : works) {
            answer += (long) work * work;
        }
        return answer;
    }

    private void swap(int[] works, int before, int after) {
        int temp = works[after];
        works[after] = works[before];
        works[before] = temp;
    }

    public long solution2(int n, int[] works) {
        Arrays.sort(works); // 정렬
        for (int i = 0; i < n; i++) {
            int max = 0; int maxIndex = 0;
            for (int j = 0; j < works.length; j++) { // 최댓값 찾기
                if (max < works[j]) {
                    max = works[j];
                    maxIndex = j;
                }
            }
            if (works[maxIndex] == 0) { // 최댓값이 0이면 모두 0
                return 0;
            }
            works[maxIndex] -= 1; // 최댓값에 -1
        }
        return getPowSum(works); // 제곱합 구하기
    }
}
