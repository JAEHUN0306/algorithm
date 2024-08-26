import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /* 두 번째로 큰 정수 찾기...
            max, min 찾고, for문 돌면서 max, min 값이랑 비교해서 둘다 아니면?..
        ->
            그냥 정렬하는 함수를 쓰면됌.
            Arrays.sort(A);
         */
        int[] A = new int[3];
        A[0] = sc.nextInt();
        A[1] = sc.nextInt();
        A[2] = sc.nextInt();

        Arrays.sort(A);

        System.out.println(A[1]);
    }
}
