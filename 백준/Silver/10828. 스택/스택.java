import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if(s.equals("pop")) {
                if(stack.size() > 0) System.out.println(stack.pop());
                else System.out.println(-1);
            } else if(s.equals("size")) {
                System.out.println(stack.size());
            } else if(s.equals("empty")) {
                if(stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if(s.equals("top")) {
                if(!stack.isEmpty()) System.out.println(stack.peek());
                else System.out.println(-1);
            } else {
                String[] split = s.split(" ");
                stack.push(Integer.parseInt(split[1]));
            }
        }

    }
}
