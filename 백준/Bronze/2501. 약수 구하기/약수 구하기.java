import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        어떤 자연수 p와 q가 있을 때, 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다.

        6을 예로 들면

        6 ÷ 1 = 6 … 0
        6 ÷ 2 = 3 … 0
        6 ÷ 3 = 2 … 0
        6 ÷ 4 = 1 … 2
        6 ÷ 5 = 1 … 1
        6 ÷ 6 = 1 … 0
        그래서 6의 약수는 1, 2, 3, 6, 총 네 개이다.

        두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.

        입력
        첫째 줄에 N과 K가 빈칸을 사이에 두고 주어진다. N은 1 이상 10,000 이하이다. K는 1 이상 N 이하이다.

        배열로 저장하고, 정렬 시키고, 출력? List에 저장 해야 할 것 같은데..
         */

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if(N % i == 0) {
                nums.add(i);
            }
        }

        if(nums.size() < K) {
            System.out.println(0);
        } else {
            System.out.println(nums.get(K-1));
        }
    }
}
