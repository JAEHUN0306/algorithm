import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.

        각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.

        입력
        첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.

        출력
        첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.
         */

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int[] counts = new int[4];
            if(str.isEmpty()) {
                break;
            }
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if(charArray[i] >= 'a' && charArray[i] <= 'z') {
                    counts[0]++;
                    continue;
                } else if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                    counts[1]++;
                    continue;
                } else if (charArray[i] >= '0' && charArray[i] <= '9') {
                    counts[2]++;
                    continue;
                } else if (charArray[i] == ' ') {
                    counts[3]++;
                    continue;
                }
            }
            System.out.println(counts[0] + " " + counts[1] + " " + counts[2] + " " + counts[3]);
        }

    }
}
