import java.util.*;

public class Solution {
	static Map<Character, Integer> map = new HashMap<>();
	static int[] dy = {0, 0, -1, 1};
	static int[] dx = {-1, 1, 0, 0};
	static char[][] field;
	static int h, w, x, y;
	public static void main(String[] args) {
		map.put('U', 0); map.put('D', 1);
		map.put('L', 2); map.put('R', 3);
		map.put('^', 0); map.put('v', 1);
		map.put('<', 2); map.put('>', 3);
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			h = sc.nextInt(); w = sc.nextInt();
			field = new char[h][];
			for (int i = 0; i < h; i++) {
				field[i] = sc.next().toCharArray();
				for (int j = 0; j < w; j++) {
					char c = field[i][j];
					if (c == '^' || c == 'v' || c == '<' || c == '>') {
						x = i; y = j;
					}
				}
			}
			sc.nextInt();
			for (char c : sc.next().toCharArray()) move(map.get(c));
			System.out.print("#"+t+" ");
			for (char[] row : field) {
				for (char c : row) System.out.print(c);
				System.out.println();
			}
		}
	}
	static void move(Integer cmd) {
		int nx = x, ny = y;
		if (cmd == null) {
			char pos = field[x][y];
			int dir = map.get(pos);
			while (pos != '*' && pos != '#') {
				nx += dx[dir];
				ny += dy[dir];
				if (nx < 0 || nx >= h || ny < 0 || ny >= w) return ;
				pos = field[nx][ny];
			}
			if (pos == '*') field[nx][ny] = '.';
		} else {
			char c = new char[]{'^', 'v', '<', '>'}[cmd];
			field[x][y] = c; 
			nx += dx[cmd];
			ny += dy[cmd];
			if (nx >= 0 && nx < h && ny >= 0 && ny < w && field[nx][ny] == '.') {
				field[nx][ny] = c;
				field[x][y] = '.';
				x = nx; y = ny;
			}
		}
	}
}