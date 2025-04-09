import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArray1 = sc.nextLine().toCharArray();
        char[] charArray2 = sc.nextLine().toCharArray();

        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < charArray1.length; i++) {
            nums1[charArray1[i] - 'a']++;
        }

        for (int i = 0; i < charArray2.length; i++) {
            nums2[charArray2[i] - 'a']++;
        }
        int count = 0;
        
        for (int i = 0; i < 26; i++) {
            count += Math.abs(nums1[i] - nums2[i]);
        }

        System.out.println(count);

    }
}
