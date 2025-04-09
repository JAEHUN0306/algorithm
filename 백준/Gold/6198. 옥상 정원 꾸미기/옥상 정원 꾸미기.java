import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.nextLine();
        Stack<Long> stack = new Stack<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            long nextHeight = sc.nextLong();
            while(!stack.isEmpty() && stack.peek() <= nextHeight) {
                stack.pop();
            }
            stack.push(nextHeight);
            count += stack.size() - 1;
        }
        System.out.println(count);
    }
}
