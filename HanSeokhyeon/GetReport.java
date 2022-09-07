/*
신고 결과 받기
1. A가 B를 신고가능 (중복은 무시)
2. 신고 받은 결과가 K번이 넘으면 계정 정지
3. 자신이 신고한 계정중에 정지가 된 계정 수를 리턴

풀이방법
1. 신고한 결과, 신고 받은 결과를 정리
2. K보다 많은 결과는 정지
3. 신고한 결과와 정지된 결과를 비교하여 최종 결과를 리턴
 */

import java.util.*;

public class GetReport {
    public static void main(String[] args) {
        GetReport getReport = new GetReport();
        int[] solution = getReport.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
        System.out.println("solution = " + Arrays.toString(solution));
        int[] solution1 = getReport.solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3);
        System.out.println("solution1 = " + Arrays.toString(solution1));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> report1 = new HashMap<>(); // 신고받은 횟수
        Map<String, List<String>> report2 = new HashMap<>(); // 내가 신고한 사람
        Map<String, Integer> visited = new HashMap<>();

        for (String name : id_list) {
            report1.put(name, 0);
            report2.put(name, new ArrayList<>());
        }

        for (String s : report) {
            if (visited.containsKey(s)) { // 중복 신고 무시
                continue;
            }
            String[] split = s.split(" ");
            String name1 = split[0];
            String name2 = split[1];

            updateReport1(report1, name2); // 신고받은 횟수 업데이트
            updateReport2(report2, name1, name2); // 내가 신고한 사람 업데이트

            visited.put(s, 0); // 중복 확인을 위해 입력
        }

        List<Integer> answer = new ArrayList<>();
        for (String name : id_list) { // 최종 체크
            int result = 0;
            List<String> names = report2.get(name); // 내가 신고한 사람들 리스트
            for (String reportedName : names) { // 신고한 사람들 중에
                Integer count = report1.get(reportedName); // 신고한 횟수
                if (count >= k) { // k를 넘으면 계정 정지
                    result += 1;
                }
            }
            answer.add(result);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private void updateReport2(Map<String, List<String>> report2, String name1, String name2) {
        List<String> strings = report2.get(name1);
        strings.add(name2);
        report2.put(name1, strings);
    }

    private void updateReport1(Map<String, Integer> report1, String name2) {
        Integer integer = report1.get(name2);
        report1.put(name2, integer+1);
    }
}
