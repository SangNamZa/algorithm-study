import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ParkingFee {
    public static void main(String[] args) {
        ParkingFee parkingFee = new ParkingFee();
        int[] solution = parkingFee.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        System.out.println("solution = " + Arrays.toString(solution));
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, Long> answer = getTimeByCar(records);
        List<String> list = answer.keySet().stream().sorted().collect(Collectors.toList());
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String carNumber = list.get(i);
            Long min = answer.get(carNumber);
            int fee = fees[1];
            if (fees[0] < min) {
                fee += Math.ceil((double) (min - fees[0]) / fees[2]) * fees[3];
            }
            result[i] = fee;
        }
        return result;
    }

    private Map<String, Long> getTimeByCar(String[] records) {
        Map<String, Long> answer = new HashMap<>();
        Map<String, Date> map = new HashMap<>();
        for (String record : records) {
            String[] s = record.split(" ");
            Date now = getTime(s[0]);
            if ("IN".equals(s[2])) {
                map.put(s[1], now);
            } else {
                Date date = map.get(s[1]);
                long min = (now.getTime() - date.getTime()) / 1000 / 60;
                if (answer.containsKey(s[1])){
                    answer.put(s[1], answer.get(s[1]) + min);
                } else {
                    answer.put(s[1], min);
                }
                map.remove(s[1]);
            }
        }
        for (String carNumber : map.keySet()) {
            Date now = getTime("23:59");
            Date date = map.get(carNumber);
            long min = (now.getTime() - date.getTime()) / 1000 / 60;
            if (answer.containsKey(carNumber)){
                answer.put(carNumber, answer.get(carNumber) + min);
            } else {
                answer.put(carNumber, min);
            }
        }
        return answer;
    }

    private Date getTime(String s) {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = f.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
