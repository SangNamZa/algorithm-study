import java.util.Stack;

public class Parenthesis {

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        boolean solution = parenthesis.solution("(())()");
        System.out.println("solution = " + solution);
    }

    boolean solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    boolean solutionSlow(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character lastC = stack.pop();
                if (lastC.equals(')')) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
