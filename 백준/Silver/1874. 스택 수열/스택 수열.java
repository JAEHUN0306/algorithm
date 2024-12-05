import java.util.Scanner;
import java.util.Stack;

public class Main {
    /*
        문제
        1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써,  -> 후입 선출 1부터 처음 수 까지는 무조건 push를 한다.
        하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
        임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
        있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

        입력
        첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
        둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
        물론 같은 정수가 두 번 나오는 일은 없다.

        출력
        입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
        push연산은 +로, pop 연산은 -로 표현하도록 한다.
        불가능한 경우 NO를 출력한다.

        */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Stack<Integer> stack = new Stack<>();

            int n = sc.nextInt();
            int[] A = new int[n];

            // 수열 입력 받기
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            int num = 1; // 오름차순으로 넣을 수
            boolean result = true;
            StringBuffer bf = new StringBuffer();

            for (int i = 0; i < n; i++) {
                int su = A[i]; // 현재 만들어야 하는 수열의 수
                if (su >= num) { // 현재 수가 넣어야 할 수보다 크거나 같으면
                    while (su >= num) { // 현재 수까지 차례대로 스택에 넣기
                        stack.push(num++);
                        bf.append("+\n");
                    }
                    stack.pop(); // 원하는 수를 꺼내기
                    bf.append("-\n");
                } else { // 현재 수가 넣어야 할 수보다 작으면
                    if (!stack.isEmpty()) {
                        int top = stack.pop(); // 스택의 top이 현재 수와 같은지 확인
                        if (top == su) {
                            bf.append("-\n");
                        } else {
                            result = false;
                            break;
                        }
                    } else {
                        result = false;
                        break;
                    }
                }
            }

            if (result) System.out.println(bf.toString());
            else System.out.println("NO");
        }

}
