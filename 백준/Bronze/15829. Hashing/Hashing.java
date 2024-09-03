import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        hash값 계산하기.
        각 자리수 i만큼 특정값(r)의 i만큼 거듭제곱 해서 곱해준다음 더한다. 그 후에 M으로 나눠준다.
        r = 31, M = 1234567891
        문자열의 길이 L, 모두 소문자로 들어온다.
        a = 1, b = 2 ... z = 26
         */

        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        long r = 31;
        long M = 1234567891;
        long sum = 0;
        long pow = 1;

        for (int i = 0; i < L; i++) {
            sum = (sum + (str.charAt(i) - 'a' + 1) * pow) % M;
            pow = (pow * r) % M;
        }

        System.out.println(sum);

    }
}
