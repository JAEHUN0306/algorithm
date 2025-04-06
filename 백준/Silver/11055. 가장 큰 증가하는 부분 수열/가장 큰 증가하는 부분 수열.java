import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dy = new int[n]; // 각 항을 마지막으로 하는 부분수열의 합 중 최댓값
        
        for(int i = 0; i < n; i++) {
            dy[i] = nums[i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) dy[i] = Math.max(dy[i], dy[j] + nums[i]);
            }
        }

        int max = dy[0];
        for (int i = 1; i < n; i++) {
            if (dy[i] > max) {
                max = dy[i];
            }
        }

        System.out.println(max);
    }
}
