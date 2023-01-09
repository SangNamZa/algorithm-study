/*
땅따먹기

한칸씩 내려가면서 점수를 획득
바로 아래칸은 못감
최댓값을 구하라
 */


public class Hopscotch {

    public static void main(String[] args) {
        Hopscotch hopscotch = new Hopscotch();
        int solution = hopscotch.solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
        System.out.println("solution = " + solution);
    }

    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int max = 0;
                for (int k = 0; k < land[0].length; k++) {
                    if (j == k) continue;
                    int nowValue = land[i-1][k];
                    if (nowValue > max) {
                        max = nowValue;
                    }
                }
                land[i][j] = land[i][j] + max;
            }
        }
        int answer = 0;
        for (int i = 0; i < land[0].length; i++) {
            if (land[land.length-1][i] > answer) {
                answer = land[land.length-1][i];
            }
        }
        return answer;
    }

    private int getResult(int beforeIndex, int result, int[][] land) {
        int answer = result;
        for (int i = 1; i < land.length; i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < land[0].length; j++) {
                if (j == beforeIndex) continue;
                if (max < land[i][j]) {
                    max = land[i][j];
                    index = j;
                }
            }
            answer += max;
            beforeIndex = index;
        }
        return answer;
    }
}
