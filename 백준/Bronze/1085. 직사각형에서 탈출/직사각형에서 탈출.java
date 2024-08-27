import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
        직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
        첫째 줄에 x, y, w, h가 주어진다.
        -> x - 0, y - 0, w - x, h - y 중에 가장 작은 값을 반환 !
        */

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[] results = new int[4];
        results[0] = x;
        results[1] = y;
        results[2] = w - x;
        results[3] = h - y;
        Arrays.sort(results);
        System.out.println(results[0]);

    }
}
