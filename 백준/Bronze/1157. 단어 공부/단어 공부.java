import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
        단, 대문자와 소문자를 구분하지 않는다. -> 모두 대문자로 바꿔도 무관

        입력
        첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

        출력
        첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
        
        
        알파벳으로 어떻게 변환하지? (char)로 변환하고 'A' 더해주면 됌.
         */

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] count = new int[26];
        int max = 0;
        char maxChar = '?';
        char[] charArray = str.toUpperCase().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            count[charArray[i] - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                maxChar = (char) (i + 'A');
            } else if (count[i] == max) {
                maxChar = '?';
            }
        }
        System.out.println(maxChar);
    }
}
