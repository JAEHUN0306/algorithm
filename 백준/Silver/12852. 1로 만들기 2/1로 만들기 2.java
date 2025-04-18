import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] dp = new int[x + 1]; // dp[i] = x가 i인 경우
        int[] prev = new int[x + 1]; // prev[i] = i에서 어떤 수로 왔는지 저장 (경로 추적용)

        dp[1] = 0;
        for(int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if(i % 2 == 0 && dp[i / 2] + 1 < dp[i]) { // 2로 나누어 떨어지는 경우
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }

            if(i % 3 == 0 && dp[i / 3] + 1 < dp[i]) { // 3으로 나누어 떨어지는 경우
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }
        System.out.println(dp[x]);
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = x; i >= 1; i = prev[i]) {
            path.add(i);
        }

        for(int num : path) {
            System.out.print(num + " ");
        }

    }
}
