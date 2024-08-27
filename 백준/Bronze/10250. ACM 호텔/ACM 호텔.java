import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        H는 층수, W는 거리. 층 만큼 먼저 올라가고 w는 1증가하는 식,
        N은 손님 수,
        만약, N이 H보다 크면 X가 1 올라간다. N/H만큼. Y는 N%H가 된다.

         */

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {

            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int Y = N % H;
            int X = N / H;

            if (Y == 0) {
                if (X < 10) System.out.println(H + "0" + X);
                else System.out.println(H + "" + X);
            } else {
                X++;
                if (X < 10) System.out.println(Y + "0" + X);
                else System.out.println(Y + "" + X);
            }
        }
    }
}
