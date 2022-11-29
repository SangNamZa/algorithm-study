/*
행렬의 곱셈
1 4
3 2     3 2 4
4 1     1 3 4

= 7 14 20
  11 12 20
  13 11 20
 */

import java.util.Arrays;

public class MulOfMatrix {

    public static void main(String[] args) {
        MulOfMatrix mulOfMatrix = new MulOfMatrix();
        int[][] solution = mulOfMatrix.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 2, 4}, {1, 3, 4}});
        System.out.println("solution = " + Arrays.deepToString(solution));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] arr2symmetric = getSymmetricArr2(arr2);
        return multiply(arr1, arr2, arr2symmetric);
    }

    private int[][] getSymmetricArr2(int[][] arr2) {
        int[][] arr2symmetric = new int[arr2[0].length][arr2.length]; // 3x2
        for (int i = 0; i < arr2symmetric.length; i++) {
            for (int j = 0; j < arr2symmetric[0].length; j++) {
                arr2symmetric[i][j] = arr2[j][i]; // 2x3 -> 3x2
            }
        }
        return arr2symmetric;
    }

    private int[][] multiply(int[][] arr1, int[][] arr2, int[][] arr2symmetric) {
        int[][] answer = new int[arr1.length][arr2symmetric.length]; // 3x3
        for (int i = 0; i < arr1.length; i++) { // 3
            for (int j = 0; j < arr2symmetric.length; j++) { // 3
                for (int k = 0; k < arr2.length; k++) { // 2
                    answer[i][j] += arr1[i][k] * arr2symmetric[j][k]; // arr1[0][0] * arr2symmetrix[0][0] + arr1[0][1] * arr2symmetrix[0][1] 
                }
            }
        }
        return answer;
    }
}
