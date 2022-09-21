/*
거리두기 확인하기

5x5를 모두 맨해튼 거리 2만큼 확인하자.
i-1, j 상
i+1, j 하
i, j-1 좌
i, j+1 우
i-2, j 상상
i+2, j 하하
i, j-2 좌좌
i, j+2 우우
i-1, j-1 상좌
i-1, j+1 상우
i+1, j-1 하좌
i+1, j+1 하우
 */

import java.util.Arrays;

public class CheckDistancing {
    public static void main(String[] args) {
        CheckDistancing checkDistancing = new CheckDistancing();
        int[] solution = checkDistancing.solution(new String[][]{{
                "POOOP",
                "OXXOX",
                "OPXPX",
                "OOXOX",
                "POXXP"
        }, {
                "POOPX",
                "OXPXP",
                "PXXXO",
                "OXXXO",
                "OOOPP"
        }, {
                "PXOPX",
                "OXOXP",
                "OXPOX",
                "OXXOP",
                "PXPOX"
        }, {
                "OOOXX",
                "XOOOX",
                "OOOXX",
                "OXOOX",
                "OOOOO"
        }, {
                "PXPXP",
                "XPXPX",
                "PXPXP",
                "XPXPX",
                "PXPXP"}});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            char[][] place = new char[5][5];
            for (int j = 0; j < 5; j++) {
                place[j] = places[i][j].toCharArray();
            }
            answer[i] = getAnswer(place);
        }
        return answer;
    }

    private int getAnswer(char[][] place) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i][j] == 'P') { // 응시자
                    for (int k = -2; k <= 2; k++) { // x가 -2 ~ 2
                        for (int l = -2; l <= 2; l++) { // y가 -2 ~ 2
                            int x = i+k; int y = j+l; // 새로운 xy
                            if (x < 0 || x >= 5 || y < 0 || y >= 5) { // 좌표 밖
                                continue;
                            }
                            int manhattenDistance = Math.abs(k) + Math.abs(l);
                            if (manhattenDistance == 1 && place[x][y] == 'P') return 0; // 맨해튼 거리가 1이고 응시자가 있으면 거리두기 X
                            if (manhattenDistance == 2 && place[x][y] == 'P') { // 맨해튼 거리가 2고 응시자가 있으면
                                if (Math.abs(k) == 1) { // 상좌상우하좌하우
                                    if (place[x][j] == 'O' || place[i][y] == 'O') return 0; // 거리두기 X
                                } else { // 상상하하좌좌우우
                                    if (k == -2 && place[x+1][y] == 'O') return 0; // 거리두기 X
                                    if (k == +2 && place[x-1][y] == 'O') return 0; // 거리두기 X
                                    if (l == -2 && place[x][y+1] == 'O') return 0; // 거리두기 X
                                    if (l == +2 && place[x][y-1] == 'O') return 0; // 거리두기 X
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}
