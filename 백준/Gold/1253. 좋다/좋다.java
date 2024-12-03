import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
    문제
    N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.

    N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.

    수의 위치가 다르면 값이 같아도 다른 수이다.

    입력
    첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

    출력
    좋은 수의 개수를 첫 번째 줄에 출력한다.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums); // 정렬
        int count = 0;

        //투 포인터
        for (int i = 0; i < n; i++) {
            int str = 0;
            int end = nums.length - 1;
            while (str < end) {
                if (str == i) {
                    str++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }

                int sum = nums[str] + nums[end];

                if (sum > nums[i]) {
                    end--;
                } else if (sum < nums[i]) {
                    str++;
                } else {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
