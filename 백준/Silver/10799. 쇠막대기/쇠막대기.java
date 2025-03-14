import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(T.solution(s));
    }

    //()(((()())(())()))(()) )을 만나면 pop하고, size를 샌걸 더해준다.
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else { // ')'인 경우
                if(s.charAt(i-1) == ')') { // 막대가 끝난경우
                    stack.pop();
                    result++;
                } else {
                    stack.pop(); // 레이저 발사
                    result += stack.size();
                }
            }
        }
        return result;
    }
}
