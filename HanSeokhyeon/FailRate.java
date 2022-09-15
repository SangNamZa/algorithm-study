import java.util.*;

/*
실패율
N과 현재 플레이어의 스테이지들이 주어지고
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
로 실패율을 구해 실패율이 높은 순으로 정렬
 */
public class FailRate {
    public static void main(String[] args) {
        FailRate failRate = new FailRate();
        int[] solution = failRate.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<Stage> players = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            players.add(new Stage(i));
        }
        for (int stage : stages) {
            if (stage == N+1) {
                continue;
            }
            Stage nowStage = players.get(stage - 1);
            nowStage.setCount(nowStage.getCount()+1);
        }

        int remainMember = stages.length;
        for (int i = 0; i < N; i++) {
            Stage stage = players.get(i);
            int count = stage.getCount();
            stage.setRate((float) count / remainMember);
            remainMember -= count;
        }

        Collections.sort(players);
        for (int i = 0; i < N; i++) {
            answer[i] = players.get(i).getStage()+1;
        }
        return answer;
    }
}

class Stage implements Comparable<Stage> {
    private final int stage;
    private int count;
    private float rate;

    public void setRate(float rate) {
        this.rate = rate;
    }

    Stage(int stage) {
        this.stage = stage;
    }

    public int getStage() {
        return stage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int compareTo(Stage stage) {
        if (this.rate > stage.rate) {
            return -1;
        } else if (this.rate < stage.rate) {
            return 1;
        } else {
            if (this.stage > stage.stage) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
