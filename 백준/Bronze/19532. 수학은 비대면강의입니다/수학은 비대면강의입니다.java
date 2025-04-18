import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        문제
        수현이는 4차 산업혁명 시대에 살고 있는 중학생이다. 코로나 19로 인해, 수현이는 버추얼 학교로 버추얼 출석해 버추얼 강의를 듣고 있다.
        수현이의 버추얼 선생님은 문자가 2개인 연립방정식을 해결하는 방법에 대해 강의하고, 다음과 같은 문제를 숙제로 냈다.
        다음 연립방정식에서 x와 y의 값을 계산하시오.
        ax+by=c
        dx+ey=f
        4차 산업혁명 시대에 숙제나 하고 앉아있는 것보다 버추얼 친구들을 만나러 가는 게 더 가치있는 일이라고 생각했던 수현이는 이런 연립방정식을 풀 시간이 없었다.
        다행히도, 버추얼 강의의 숙제 제출은 인터넷 창의 빈 칸에 수들을 입력하는 식이다. 각 칸에는 -999 이상 999 이하의 정수만 입력할 수 있다.
        수현이가 버추얼 친구들을 만나러 버추얼 세계로 떠날 수 있게 도와주자.

        입력 정수 a, b, c, d, e, f 공백으로 구분되어 차례대로 주어진다. (-999 <= a,b,c,d,e,f <= 999)

        문제에서 언급한 방정식을 만족하는 x, y는 하나만 존재,

        출력
        x, y를 공백으로 구분해 출력하시오.
        */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        int denominator = a * e - b * d;
        if (denominator == 0) {
            System.out.println("No unique solution");
            return;
        }

        int x = (c * e - b * f) / denominator;
        int y = (a * f - c * d) / denominator;

        System.out.println(x + " " + y);
    }
}
