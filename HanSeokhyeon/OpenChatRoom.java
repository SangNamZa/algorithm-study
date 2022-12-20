import java.util.*;

public class OpenChatRoom {

    private final Map<String, String> idNameMap = new HashMap<>();
    private final List<Message> messages = new ArrayList<>();

    public static void main(String[] args) {
        OpenChatRoom openChatRoom = new OpenChatRoom();
        String[] solution = openChatRoom.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public String[] solution(String[] record) {
        for (String s : record) {
            addMessage(s);
        }
        return getAnswer();
    }

    private void addMessage(String s) {
        String[] split = s.split(" ");
        String operation = split[0];
        String id = split[1];

        if ("Enter".equals(operation)) {
            messages.add(new Message(operation, id));
            idNameMap.put(id, split[2]);
        } else if ("Leave".equals(operation)) {
            messages.add(new Message(operation, id));
        } else {
            idNameMap.put(id, split[2]);
        }
    }

    private String[] getAnswer() {
        String[] answer = new String[messages.size()];
        for (int i = 0; i < answer.length; i++) {
            Message message = messages.get(i);
            answer[i] = message.toString(idNameMap.get(message.id));
        }
        return answer;
    }

    static class Message {
        String operation;
        String id;

        public Message(String operation, String id) {
            this.operation = operation;
            this.id = id;
        }

        public String toString(String name) {
            if ("Enter".equals(operation)) {
                return name + "님이 들어왔습니다.";
            } else {
                return name + "님이 나갔습니다.";
            }
        }
    }
}
