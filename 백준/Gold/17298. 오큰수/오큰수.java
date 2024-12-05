import java.util.Scanner;
import java.util.Stack;

public class Main {
    /*
    문제
    크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
    Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.

    예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
    A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

    입력
    첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

    출력
    총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
     */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] A = new int[n];    // 수열 저장
            int[] result = new int[n];  // 결과 배열
            Stack<Integer> stack = new Stack<>();

            // 수열 입력받기
            for(int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }

            // 스택에 첫 번째 수의 '인덱스' 저장
            stack.push(0);

            // 두 번째 수부터 비교 시작
            for(int i = 1; i < n; i++) {
                // 스택이 비어있지 않고, 현재 수가 스택 top이 가리키는 수보다 크면
                while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
                    result[stack.pop()] = A[i];  // 오큰수 저장
                }
                stack.push(i); // 현재 인덱스를 스택에 저장
            }

            // 스택에 남은 인덱스들은 오큰수가 없음
            while(!stack.isEmpty()) {
                result[stack.pop()] = -1;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++) {
                sb.append(result[i]).append(" ");
            }

            System.out.println(sb);
        }
    }
