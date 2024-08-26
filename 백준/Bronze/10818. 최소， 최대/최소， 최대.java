import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = -1000000;
        int min = 1000000;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
            if(min > nums[i]) {
                min = nums[i];
            }
        }

        System.out.printf("%d %d", min, max);
    }
}
