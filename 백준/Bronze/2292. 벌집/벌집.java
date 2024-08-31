import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        위의 그림과 같이 육각형으로 이루어진 벌집이 있다.
        그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
        숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는
        프로그램을 작성하시오. 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.

        입력
        첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.

        출력
        입력으로 주어진 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나는지 출력한다.

        1 -> 7 -> 19 -> 37 -> 61
          +6n  +6n   +6n   +6n..

          (n * n + n) * 3 + 1
        */

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int boundary = 1;

        while (boundary < N) {
            boundary += 6 * count;
            count++;
        }

        System.out.println(count);
    }
}
