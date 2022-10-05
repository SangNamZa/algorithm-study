/*
로또의 최고 순위와 최저 순위
 */

import java.util.Arrays;

public class BestLottoAndWorstLotto {

    public static void main(String[] args) {
        BestLottoAndWorstLotto bestLottoAndWorstLotto = new BestLottoAndWorstLotto();
//        int[] solution = bestLottoAndWorstLotto.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
//        int[] solution = bestLottoAndWorstLotto.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        int[] solution = bestLottoAndWorstLotto.solution(new int[]{1, 2, 3, 4, 5, 6}, new int[]{7, 8, 9, 10, 11, 12});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = find(lottos, 0); // 0의 개수
        int same = 0;
        for (int i = 0; i < 6; i++) {
            same += find(lottos, win_nums[i]); // 일치하는 수
        }
        int worst = 7-same; // 2개 일치하면 5등, 6개 일치하면 1등
        int best = worst-zero; // 2개 일치하고 0이 2개면 4개 일치 -> 5 - 2 = 3등
        best = best == 7 ? 6 : best; // 0개 일치하면 7등 -> 6등
        worst = worst == 7 ? 6 : worst; // 7등에서 0이 없으면 7등 -> 6등
        return new int[]{best, worst};
    }

    private int find(int[] lottos, int target) {
        int count = 0;
        for (int lotto : lottos) {
            if (lotto == target) {
                count++;
            }
        }
        return count;
    }
}
