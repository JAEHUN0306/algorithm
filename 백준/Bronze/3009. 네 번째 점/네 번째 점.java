import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.
        세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
        (1, 4) (2, 3) (2, 4) -> (1, 3)

        좌표가 주어 졌을 떄 하나 만 있는거... 이걸 어떻게 프로그램으로 표헌하지?..

         */
        Scanner sc = new Scanner(System.in);
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int x4, y4;

        if(x[0] == x[1]) x4 = x[2];
        else if(x[0] == x[2]) x4 = x[1];
        else x4 = x[0];

        if(y[0] == y[1]) y4 = y[2];
        else if(y[0] == y[2]) y4 = y[1];
        else y4 = y[0];

        System.out.println(x4 + " " + y4);
    }
}
