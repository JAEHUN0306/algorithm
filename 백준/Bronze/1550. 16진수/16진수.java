import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        16진수 수를 입력받아서 10진수로 출력하는 프로그램을 작성하시오.

        입력
        첫째 줄에 16진수 수가 주어진다. 이 수의 최대 길이는 6글자이다.
        16진수 수는 0~9와 A~F로 이루어져 있고, A~F는 10~15를 뜻한다. 또, 이 수는 음이 아닌 정수이다.

        출력
        첫째 줄에 입력으로 주어진 16진수 수를 10진수로 변환해 출력한다.
        A = 10 B = 11 C = 12 D=13 E=14 F=15
        -> char - 'A' + 10
         */

        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int result = 0;

        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int digit;
            if (c >= 'A' && c <= 'F') {
                digit = c - 'A' + 10;
            } else {
                digit = c - '0';
            }
            result = result * 16 + digit;
        }

        System.out.println(result);

    }
}
