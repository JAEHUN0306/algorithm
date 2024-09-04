import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        내일은 일본과 국가대표 친선 경기가 있는 날이다. 상근이는 내일 경기에 나설 선발 명단을 작성해야 한다.

        국가대표팀의 감독이 된 이후에 상근이는 매우 게을러졌다. 그는 선수의 이름을 기억하지 못하고, 각 선수의 능력도 알지 못한다.
        따라서, 누가 선발인지 기억하기 쉽게 하기 위해 성의 첫 글자가 같은 선수 5명을 선발하려고 한다.
        만약, 성의 첫 글자가 같은 선수가 5명보다 적다면, 상근이는 내일 있을 친선 경기를 기권하려고 한다.

        상근이는 내일 경기를 위해 뽑을 수 있는 성의 첫 글자를 모두 구해보려고 한다.

        입력
        첫째 줄에 선수의 수 N (1 ≤ N ≤ 150)이 주어진다. 다음 N개 줄에는 각 선수의 성이 주어진다. (성은 알파벳 소문자로만 이루어져 있고, 최대 30글자이다)

        출력
        상근이가 선수 다섯 명을 선발할 수 없는 경우에는 "PREDAJA" (따옴표 없이)를 출력한다. PREDAJA는 크로아티아어로 항복을 의미한다.
        선발할 수 있는 경우에는 가능한 성의 첫 글자를 사전순으로 공백없이 모두 출력한다.
         */
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        sc.nextLine();

        int[] counts = new int[26];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            char firstChar = str.charAt(0);
            counts[firstChar - 'a']++;
        }

        boolean found = false;
        for (int i = 0; i < 26; i++) {
            if(counts[i] >= 5) {
                sb.append((char)(i + 'a'));
                found = true;
            }
        }

        if(found) {
            System.out.println(sb.toString());
        } else{
            System.out.println("PREDAJA");
        }
    }
}
