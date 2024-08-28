import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        <그림 1>과 같이 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.

        크기 81인 배열을 만들고 모든 수를 담는다. n번의 비교 후 최댓값을 찾고, 최댓값의 인덱스를 알아낸 후 -> 좌표로 표현하기.
        index + 1 / 9 -> 행, index + 1 % 9 -> 열
         */

        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[81];
        int max = -1;
        int maxIndex = -1;

        // 입력 받기 및 최댓값 찾기
        for (int i = 0; i < 81; i++) {
            numbers[i] = sc.nextInt();
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
        }

        // 행과 열 계산
        int row = (maxIndex / 9) + 1;
        int col = (maxIndex % 9) + 1;

        // 결과 출력
        System.out.println(max);
        System.out.println(row + " " + col);

    }
}
