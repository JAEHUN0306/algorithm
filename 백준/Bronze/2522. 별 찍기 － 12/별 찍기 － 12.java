import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
           *  공백 2 별 1
          **  공백 1 별 2
         ***  공백 0 별 3
          **  공백 1 별 2
           *  공백 2 별 1
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) { // 행 제어
            for (int j = 0; j < n - i - 1 ; j++) { // 공백 제어
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*"); // 별 제어
            }
            System.out.println();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
