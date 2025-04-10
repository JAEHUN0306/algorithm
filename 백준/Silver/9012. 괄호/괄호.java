import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String s = sc.nextLine();
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if(c == '(') stack.push(c);
                else if(c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if(!stack.isEmpty()) flag = false;

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
