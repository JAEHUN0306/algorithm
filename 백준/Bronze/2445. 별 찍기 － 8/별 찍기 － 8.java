import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         *        * 별1, 공백4 | 공백 4 별 1
         **      ** 별2, 공백3 | 공백 3 별 2
         ***    *** 별3, 공백2 | 공백 2 별 3
         ****  **** 별4, 공백1 | 공백 1 별 4
         ********** 별5, 공백0 | 공백 0 별 5
         ****  **** 별4, 공백1 | 공백 1 별 4
         ***    *** 별3, 공백2 | 공백 2 별 3
         **      ** 별2, 공백3 | 공백 3 별 2
         *        * 별1, 공백4 | 공백 4 별 1
        */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - i - 1 ; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n - i - 1 ; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1 ; j++) {
                System.out.print("*");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i - 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
