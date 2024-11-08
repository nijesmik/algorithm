import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(N, numbers));
    }

    public static long solution(int N, int[] numbers) {
        Map<Integer, Long>[] dp = new HashMap[N - 1];

        for (int i = 0; i < N - 1; i++) {
            dp[i] = new HashMap<>();
        }

        dp[0].put(numbers[0], 1L);

        for (int i = 1; i < N - 1; i++) {
            int number = numbers[i];
            for (Map.Entry<Integer, Long> entry : dp[i - 1].entrySet()) {
                int sum = entry.getKey();
                long count = entry.getValue();

                push(dp[i], sum + number, count);
                push(dp[i], sum - number, count);
            }
        }

        return dp[N - 2].getOrDefault(numbers[N - 1], 0L);
    }

    private static void push(Map<Integer, Long> map, int n, long count) {
        if (n >= 0 && n <= 20) {
            map.put(n, map.getOrDefault(n, 0L) + count);
        }
    }
}
