import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int wait = 0, total = 0;
		for (int i : arr) {
			wait += i;
			total += wait;
		}
		System.out.println(total);
	}
}