import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) { // 1001
            String[] split = sc.nextLine().split(" ");
            char[] charArray1 = split[0].toCharArray();
            char[] charArray2 = split[1].toCharArray();
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            String s1 = new String(charArray1);
            String s2 = new String(charArray2);
            if(s1.equals(s2)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }

        }
    }
}
