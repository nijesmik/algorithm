import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = (sc.nextLine()+"+").toCharArray();
		long num = 0, sum1 = 0, sum2 = 0;
		boolean flag = true;
		for (char c : arr) {
			if (flag && c == '-') {
				flag = false;
				sum1 += num;
				num = 0;
			} else if (c == '-' || c == '+') {
				if (flag) sum1 += num;
				else sum2 += num;
				num = 0;
			} else {
				num = num * 10 + c - '0';
			}
		}
		System.out.println(sum1-sum2);
	}
}