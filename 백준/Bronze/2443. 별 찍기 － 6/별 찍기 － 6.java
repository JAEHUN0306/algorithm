import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         ********* 공백 0 별 9
          *******  공백 1 별 7
           *****   공백 2 별 5 ...
            ***
             *
         */

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) { // 행 제어
            for (int j = 0; j < i; j++) { // 공백 제어
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * n - 1 - 2 * i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
