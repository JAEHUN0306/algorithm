import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[26];
        char[] charArray = sc.nextLine().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            nums[charArray[i] - 'a']++;
        }

        for (int x : nums) {
            System.out.print(x + " ");
        }

    }
}
