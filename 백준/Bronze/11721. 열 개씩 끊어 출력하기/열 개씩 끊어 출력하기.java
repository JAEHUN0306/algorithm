import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.
        한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.

        첫째 줄에 단어가 주어진다. 단어는 알파벳 소문자와 대문자로만 이루어져 있으며, 길이는 100을 넘지 않는다. 길이가 0인 단어는 주어지지 않는다.
         */

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            if((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
