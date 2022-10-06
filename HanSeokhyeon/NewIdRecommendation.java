/*
신규 아이디 추천

1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
 */

public class NewIdRecommendation {

    public static void main(String[] args) {
        NewIdRecommendation newIdRecommendation = new NewIdRecommendation();
        String solution = newIdRecommendation.solution("...!@BaT#*..y.abcdefghijklm");
        System.out.println("solution = " + solution);
    }

    public String solution(String new_id) {
        new_id = new_id.toLowerCase(); // 1단계 소문자

        new_id = new_id.replaceAll("[^0-9a-z-_.]", ""); // 2단계 불필요 글자 제거

        new_id = removeMultiDot(new_id); // 3단계 중복 . 제거

        new_id = removeFrontDotAndRearDot(new_id); // 4단계 맨앞맨뒤 . 제거

        new_id = initNewId(new_id); // 5단계 빈문자열 -> "a"

        new_id = cutLongId(new_id); // 6단계 16+자 -> 15자

        new_id = addShortId(new_id); // 7단계 2-자 -> 3자

        return new_id;
    }

    private String removeMultiDot(String new_id) {
        StringBuilder next_new_id = new StringBuilder(new_id.substring(0, 1)); // 첫글자 추가
        for (int i = 1; i < new_id.length(); i++) { // 2번째 글자부터
            if (!(new_id.charAt(i-1) == '.' && new_id.charAt(i) == '.')) { // 이전글자와 현재글자가 모두 .이 아니면
                next_new_id.append(new_id.charAt(i)); // 추가
            }
        }
        new_id = next_new_id.toString();
        return new_id;
    }

    private String removeFrontDotAndRearDot(String new_id) {
        if (new_id.charAt(0) == '.') { // 첫번째가 .이면
            new_id = new_id.substring(1); // 제거
        }
        if (!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.') { // 마지막이 .이면
            new_id = new_id.substring(0, new_id.length()-1); // 제거
        }
        return new_id;
    }

    private String initNewId(String new_id) {
        if (new_id.isEmpty()) { // 빈문자열이면
            new_id = "a"; // a
        }
        return new_id;
    }

    private String cutLongId(String new_id) {
        if (new_id.length() > 15) { // 15자 이상이면
            new_id = new_id.substring(0, 15); // 자르기
            if (new_id.charAt(new_id.length()-1) == '.') { // 맨뒤가 .이면
                new_id = new_id.substring(0, new_id.length()-1); // 자르기
            }
        }
        return new_id;
    }

    private String addShortId(String new_id) {
        StringBuilder new_idBuilder = new StringBuilder(new_id);
        while (new_idBuilder.length() < 3) { // 3자보다 작으면
            new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1)); // 마지막글자를 추가
        }
        new_id = new_idBuilder.toString();
        return new_id;
    }
}
