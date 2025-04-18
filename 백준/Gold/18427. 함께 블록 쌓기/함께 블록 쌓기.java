import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            list.add(new ArrayList<Integer>());
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        long[][] dp = new long[n + 1][h + 1]; //  i번째 학생까지 고려했을 때, 높이 j인 탑을 만들 수 있는 경우의 수
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            //블록을 사용하지 않은 경우
            for (int j = 0; j <= h; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            //블록을 사용 한 경우
            for (int height : list.get(i)) {
                if(height <= h) {
                    for (int j = height; j <= h; j++) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j-height]) % 10007;
                    }
                }
            }
        }

        System.out.println(dp[n][h]);

    }
}
