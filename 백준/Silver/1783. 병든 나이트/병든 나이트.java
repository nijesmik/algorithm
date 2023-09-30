import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(), c = sc.nextInt();
		int ans = 0;
		if (r == 1) ans = 1;
		else if (r == 2) {
			ans = Math.min(4, (c+1)/2);
		} else {
			if (c < 7) ans = Math.min(c, 4);
			else ans = c - 2;
		}
		System.out.println(ans);
	}
}