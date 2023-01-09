/*
스킬트리

CBD : 선행스킬
"BACDE": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
"CBADF": 가능한 스킬트리입니다.
"AECB": 가능한 스킬트리입니다.
"BDA": B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

return 2
 */

import java.util.ArrayList;
import java.util.List;

public class SkillTree {

    public static void main(String[] args) {
        SkillTree skillTree = new SkillTree();
        int cbd = skillTree.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
        System.out.println("cbd = " + cbd);
    }

    public int solution(String skill, String[] skill_trees) {
        char[] skills = skill.toCharArray();
        int answer = 0;
        for (String skillTree : skill_trees) {
            answer += checkValid(skills, skillTree); // 올바르면 +1
        }
        return answer;
    }

    private Integer checkValid(char[] skills, String skillTree) {
        List<Integer> indice = new ArrayList<>();
        for (char skill : skills) {
            indice.add(skillTree.indexOf(skill)); // [ 2, 0, 3 ]
        }
        Integer before = indice.get(0);
        for (int i = 1; i < indice.size(); i++) {
            Integer after = indice.get(i);
            if ((before == -1 && after != -1) // 선행스킬은 없는데 후행스킬이 존재하는 경우
                || (before > after && after != -1)) { // 선행스킬이 후행스킬보다 더 뒤에 존재하는 경우 (후행스킬이 없는 경우는 인정)
                return 0;
            }
            before = after;
        }
        return 1;
    }
}
