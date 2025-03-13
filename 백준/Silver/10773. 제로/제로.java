import java.util.*;
class Main {
    public static void main(String[] agrs) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x == 0 && !stack.isEmpty()) {
                int popNum = stack.pop();
                sum -= popNum;
            } else {
                stack.push(x);
                sum += x;
            }
        }
        System.out.println(sum);
        
    }
}