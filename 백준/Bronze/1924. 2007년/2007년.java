import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        오늘은 2007년 1월 1일 월요일이다. 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.

        입력
        첫째 줄에 빈 칸을 사이에 두고 x(1 ≤ x ≤ 12)와 y(1 ≤ y ≤ 31)이 주어진다.
        참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.

        출력
        첫째 줄에 x월 y일이 무슨 요일인지에 따라 SUN, MON, TUE, WED, THU, FRI, SAT중 하나를 출력한다.
        */
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int days = 0;

        for (int i = 1; i < x; i++) {
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                days += 31;
            } else if(i == 4 || i == 6 || i == 9 || i == 11) {
                days += 30;
            } else {
                days += 28;
            }
        }
        days += y;
        days = (days - 1) % 7;
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        System.out.println(day[days]);
    }
}
