import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[10];
        while(n / 10 > 0) {
            nums[n % 10]++;
            n /= 10;
        }
        nums[n]++;
        nums[6] += nums[9];
        nums[9] = 0;
        if(nums[6] % 2 == 0) {
            nums[6] /= 2;
        } else {
            nums[6] = nums[6] / 2 + 1;
        }
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if(nums[i] > max) max = nums[i];
        }

        System.out.println(max);
    }
}
