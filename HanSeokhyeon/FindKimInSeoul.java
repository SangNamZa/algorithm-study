public class FindKimInSeoul {
    public static void main(String[] args) {
        FindKimInSeoul findKimInSeoul = new FindKimInSeoul();
        String solution = findKimInSeoul.solution(new String[]{"Jane", "Kim"});
        System.out.println("solution = " + solution);
    }

    public String solution(String[] seoul) {
        String answer = "김서방은 %d에 있다";
        for (int i = 0; i < seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                return String.format(answer, i);
            }
        }
        return answer;
    }
}
