import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        입력
        첫째 줄에 테스트케이스의 개수
        $T$가 주어진다. (
        $1 \leq T \leq 1\,000$)

        둘째 줄부터
        $T$개의 줄에 알파벳 대문자로 구성된 문자열
        $S$가 주어진다. (
        $1 \leq \vert S\vert \leq 1\,000$)

        출력
        각 테스트케이스마다, isPalindrome 함수의 반환값과 recursion 함수의 호출 횟수를 한 줄에 공백으로 구분하여 출력한다.
         */

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int count = 0;
        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                count++;
                if (str.charAt(j)==str.charAt(str.length() -1 - j)) {
                    if(j >= str.length() -1 - j) {
                        System.out.print("1");
                        System.out.print(" " + count);
                        System.out.println();
                        break;
                    }
                } else {
                    System.out.print("0");
                    System.out.print(" " + count);
                    System.out.println();
                    break;
                }
            }
            count = 0;

        }
    }
}
