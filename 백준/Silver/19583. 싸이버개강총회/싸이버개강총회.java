import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] times = br.readLine().split(" ");
        String S = times[0]; // 개강 총회 시작
        String E = times[1]; // 개강 총회 종료
        String Q = times[2]; // 스트리밍 종료

        Set<String> set = new HashSet<>();
        int count = 0;

        int startTime = getMinute(S);
        int endTime = getMinute(E);
        int streamingEndTime = getMinute(Q);

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            String time = parts[0];
            String name = parts[1];
            int minTime = getMinute(time);

            if (minTime <= startTime) {
                set.add(name);
            } else if (minTime >= endTime && minTime <= streamingEndTime) {
                if (set.contains(name)) {
                    set.remove(name);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static int getMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
