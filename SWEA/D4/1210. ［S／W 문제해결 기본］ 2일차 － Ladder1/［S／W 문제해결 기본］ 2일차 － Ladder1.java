import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int point = 0;
			int[][] map = new int[100][102];
			for (int i = 0; i < 100; i++) {
				for (int j = 1; j <= 100; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) point = j;
				}
			}
			int direction = 0;
			for (int i = 98; i > 0; i--) {
				if (map[i][point+1] == 1)
					direction = 1;
				else if (map[i][point-1] == 1)
					direction = -1;
				while (direction != 0 && map[i][point+direction] == 1)
					point += direction;
				direction = 0;
			}
			System.out.printf("#%d %d\n", t, point-1);
		}
	}
}