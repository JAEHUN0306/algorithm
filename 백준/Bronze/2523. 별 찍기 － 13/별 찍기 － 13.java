import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
             *
             **
             ***
             **
             *
             별찍기
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = n; j > i + 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
