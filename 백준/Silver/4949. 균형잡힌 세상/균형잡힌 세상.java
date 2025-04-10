import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String s = sc.nextLine();
            if (s.equals(".")) break;

            boolean flag = true;
            Stack<Character> stack = new Stack<>();

            for(char c : s.toCharArray()) {
                if(c == '(' || c == '[') stack.push(c);

                else if (c == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    else stack.pop();
                }

                else if (c == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    } else stack.pop();
                }

            }

            if(!stack.isEmpty()) flag = false;
            if(flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
