import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String target = sc.nextLine();

        int cnt = 0, index = input.indexOf(target);
        while (index > -1) {
            cnt++;
            input = input.substring(index + target.length());
            index = input.indexOf(target);
        }
        System.out.println(cnt);
    }
}