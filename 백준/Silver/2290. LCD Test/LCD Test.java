import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int size;
    static List<Integer> numbers;
    static Display[] monitor;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        numbers = new ArrayList<>();
        char[] digits = sc.next().toCharArray();
        for (char digit : digits) {
            numbers.add(digit - '0');
        }

        monitor = new Display[7];
        for (int i = 0; i < 7; i++) {
            monitor[i] = new Display();
        }
        monitor[0].display = new HashSet<>(List.of(1, 4));
        monitor[1].display = new HashSet<>(List.of(1, 2, 3, 7));
        monitor[2].display = new HashSet<>(List.of(5, 6));
        monitor[3].display = new HashSet<>(List.of(1, 7, 0));
        monitor[4].display = new HashSet<>(List.of(1, 3, 4, 5, 7, 9));
        monitor[5].display = new HashSet<>(List.of(2));
        monitor[6].display = new HashSet<>(List.of(1, 4, 7));

        sb = new StringBuilder();
        int idx = 0;
        while (idx < 7) {
            int cnt = 1;
            if (idx % 3 != 0)
                cnt = size;
            while (cnt-- > 0) {
                createLine(idx);
            }
            if (idx % 3 == 1) {
                idx++;
            }
            idx++;
        }
        System.out.println(sb);
    }

    static void createLine(int idx) {
        for (int number : numbers) {
            append(number, idx);
            sb.append(" ");
        }
        sb.append("\n");
    }

    static void append(int number, int idx) {
        String left = " ", middle = " ", right = " ";
        if (idx % 3 == 0) {
            if (!monitor[idx].display.contains(number)) {
                middle = "-";
            }
        } else if (idx == 1 || idx == 4) {
            if (!monitor[idx].display.contains(number)) {
                left = "|";
            }
            if (!monitor[idx + 1].display.contains(number)) {
                right = "|";
            }
        }

        sb.append(left);
        for (int i = 0; i < size; i++) {
            sb.append(middle);
        }
        sb.append(right);
    }

    static class Display {
        Set<Integer> display;
    }
}
