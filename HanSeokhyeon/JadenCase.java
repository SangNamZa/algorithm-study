public class JadenCase {

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();
        String solution = jadenCase.solution("3people unFollowed me ");
        System.out.println("solution = " + solution);
    }

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] strings = s.split(" "); // 공백기준으로 나누기 다만 마지막에 공백이 붙은 경우 사라짐
        for (String string : strings) { // 문자열을 하나씩 가져오며
            for (int i = 0; i < string.length(); i++) { // 알파벳을 하나씩 체크
                answer.append(getString(string, i));
            }
            answer.append(" "); // 공백으로 연결
        }
        if (s.charAt(s.length()-1) == ' ') { // 마지막에 공백이었던 경우
            return answer.toString(); // 그냥 리턴
        }
        return answer.substring(0, answer.length()-1); // 마지막에 들어갔을 공백 제거
    }

    private String getString(String string, int i) {
        char c = string.charAt(i);
        String str = Character.toString(c);
        if (i == 0) { // 맨앞글자
            if (Character.isAlphabetic(c) && Character.isLowerCase(c)) { // 알파벳이고 소문자면
                str = str.toUpperCase(); // 대문자로 변환
            }
        } else { // 중간글자
            if (Character.isAlphabetic(c) && Character.isUpperCase(c)) { // 알파벳이고 대문자면
                str = str.toLowerCase(); // 소문자로 변환
            }
        }
        return str;
    }
}
