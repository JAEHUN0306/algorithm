import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }
        System.out.println(T.solution(n, strs));
    }

    public int solution(int n, String[] strings) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            for(char c : strings[i].toCharArray()) {
                if(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else stack.push(c);
            }
            if(stack.isEmpty()) answer++;
        }
        return answer;
    }
}
