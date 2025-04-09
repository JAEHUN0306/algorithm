import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner 대신 BufferedReader 사용 (더 효율적)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        // 로직 처리
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && height[stack.peek() - 1] < height[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()){
                answer[i] = stack.peek();
            } else {
                answer[i] = 0;
            }

            stack.push(i + 1);
        }

        // 결과 출력 - StringBuilder 사용
        StringBuilder sb = new StringBuilder();
        for(int x : answer) {
            sb.append(x).append(" ");
        }
        System.out.print(sb.toString());
    }
}