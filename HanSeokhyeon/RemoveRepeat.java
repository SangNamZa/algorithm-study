public class RemoveRepeat {
    public static void main(String[] args) {
        RemoveRepeat removeRepeat = new RemoveRepeat();
        int baabaa = removeRepeat.solution("baabaa");
        System.out.println("baabaa = " + baabaa);
    }

    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() == 0) {
            return 1;
        }
        return 0;
    }
}
