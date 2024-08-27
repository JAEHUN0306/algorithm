import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        별찍기 -> 모래시계
             ********* 공백 0 별 9
              *******  공백 1 별 7
               *****   공백 2 별 5
                ***    공백 3 별 3
                 *     공백 4 별 1
                ***    공백 3 별 3
               *****   공백 2 별 5
              *******  공백 1 별 7
             ********* 공백 0 별 9
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) { // 행 제어
            for (int k = 0; k < i; k++) { // 공백 제어
                System.out.print(" ");
            }
            for (int j = 0; j < n * 2 - 1 - (2 * i); j++) { // 별 제어
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) { // 행 제어
            for (int j = 0; j < n - i - 1; j++) { // 공백 제어
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
