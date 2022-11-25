/*
괄호 회전하기

s 길이만큼 돌면서
올바른 괄호 문자열인지 체크
1000 * 1000 = 1,000,000 이니깐 시간 괜찮을듯?
 */

import java.util.ArrayDeque;
import java.util.Stack;

public class ParenthesisRotation {

    public static void main(String[] args) {
        ParenthesisRotation parenthesisRotation = new ParenthesisRotation();
//        int solution = parenthesisRotation.solution("[");
        int solution = parenthesisRotation.solution("}]()[{");
        System.out.println("solution = " + solution);
    }

    public int solution(String s) {
        ArrayDeque<Character> deque = getDeque(s); // 문자열을 deque으로 변환

        int answer = 0;
        for (int i = 0; i < s.length(); i++) { // 문자열 길이만큼 쉬프트
            ArrayDeque<Character> clone = deque.clone(); // 다음 iteration을 위해 복제
            Stack<Character> stack = new Stack<>(); // 괄호 담아두는 stack
            boolean isRight = true; // flag
            for (int j = 0; j < s.length(); j++) { // deque에서 하나씩 꺼내며 올바른 괄호인지 체크
                char c = deque.removeFirst(); // 맨 앞 문자 꺼내기
                isRight = updateFlag(stack, isRight, c); // 올바른 괄호인지 체크
            }

            if (isRight && stack.empty()) { // 올바른 괄호 + 스택이 비었으면
                answer++; // count +1
            }
            deque = shiftDeque(clone); // 복제해둔 deque 가져와서 쉬프트
        }
        return answer;
    }

    private ArrayDeque<Character> shiftDeque(ArrayDeque<Character> clone) {
        clone.addLast(clone.removeFirst()); // 쉬프트
        return clone;
    }

    private boolean updateFlag(Stack<Character> stack, boolean isRight, char c) {
        if (c == '[' || c == '{' || c == '(') { // 여는 괄호면
            stack.add(c); // 스택에 add
        } else { // 닫는 괄호면
            if (stack.isEmpty()) { // 스택에 아무것도 없으면 올바르지 않은 괄호
                isRight = false;
            } else {
                Character target = stack.pop(); // 스택에서 pop해오고
                if ((target == '[' && c != ']')
                        || (target == '{' && c != '}')
                        || (target == '(' && c != ')')) { // 짝이 안맞으면 올바르지 않은 괄호
                    isRight = false;
                }
            }
        }
        return isRight;
    }

    private ArrayDeque<Character> getDeque(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i));
        }
        return deque;
    }
}
