import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer[]> stack = new Stack<>();
		for (int i = 1; i <= n; i++) {
			Integer[] tower = {Integer.parseInt(st.nextToken()), i};
			while (!stack.isEmpty() && stack.peek()[0] < tower[0]) {
				stack.pop();
			}
			int idx = 0;
			if (!stack.isEmpty()) idx = stack.peek()[1];
			System.out.print(idx+" ");
			stack.add(tower);
		}
	}
}