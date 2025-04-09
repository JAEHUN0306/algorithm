import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String keylog = sc.nextLine();
            LinkedList<Character> password = new LinkedList<>();
            ListIterator<Character> iter = password.listIterator();

            for (char c : keylog.toCharArray()) {
                switch(c) {
                    case '<' :
                        if (iter.hasPrevious()) iter.previous();
                        break;
                    case '>' :
                        if (iter.hasNext()) iter.next();
                        break;
                    case '-' :
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : password) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}