import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();


        if(min >= 45) {
            min = min - 45;
        } else {
            hour -= 1;
            min = min + 60 - 45;
            if(hour == -1) {
                hour = 23;
            }
        }
        System.out.printf("%d %d", hour, min);
    }
}
