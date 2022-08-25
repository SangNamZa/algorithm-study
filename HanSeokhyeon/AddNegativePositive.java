public class AddNegativePositive {

    public static void main(String[] args) {
        AddNegativePositive addNegativePositive = new AddNegativePositive();
        int solution = addNegativePositive.solution(new int[]{4, 7, 12}, new boolean[]{true, false, true});
        System.out.println(solution);
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
