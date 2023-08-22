import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) list.add(sc.nextInt());
			int cmdNum = sc.nextInt();
			for (int i = 0; i < cmdNum; i++) {
				char cmd = sc.next().charAt(0);
				if (cmd == 'I') {
					int x = sc.nextInt(), y = sc.nextInt();
					for (int j = 0; j < y; j++) list.add(x+j, sc.nextInt());
				} else if (cmd == 'D') {
					int x = sc.nextInt(), y = sc.nextInt();
					for (int j = 0; j < y; j++) list.remove(x);
				} else {
					int y = sc.nextInt();
					for (int j = 0; j < y; j++) list.add(sc.nextInt());
				}
			}
			String ans = "#"+t;
			for (int i = 0; i < 10; i++) ans += " "+list.get(i);
			System.out.println(ans);
		}
		sc.close();
	}
}