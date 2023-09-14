import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] meeting = new int[n][2];
		while (n-- > 0) {
			meeting[n][0] = sc.nextInt();
			meeting[n][1] = sc.nextInt();
		}
		Arrays.sort(meeting, (a,b)-> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		int cnt = 0, prev = 0;
		for (int[] arr : meeting) {
			if (arr[0] >= prev) {
				cnt++;
				prev = arr[1];
			}
		}
		System.out.println(cnt);
	}
}