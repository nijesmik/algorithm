import java.util.*;
import java.util.stream.*;

public class Solution {
    Queue<Code> codes = new LinkedList<>();

    public int solution(int n, int[][] q, int[] ans) {
        dfs(n, 0, 1);

        for (int i = 0; i < q.length; i++) {
            Set<Integer> query = Arrays.stream(q[i]).boxed().collect(Collectors.toSet());

            int size = codes.size();
            while (size-- > 0) {
                Code code = codes.poll();
                if (code.isValid(query, ans[i])) {
                    codes.add(code);
                }
            }

        }
        
        return codes.size();
    }

    int[] code = new int[5];

    void dfs(int n, int depth, int start) {
        if (depth == 5) {
            codes.add(new Code(code));
            return;
        }

        for (int i = start; i <= n - 4 + depth; i++) {
            code[depth] = i;
            dfs(n, depth + 1, i + 1);
        }
    }

    class Code {
        int[] code;

        Code(int[] code) {
            this.code = Arrays.copyOf(code, code.length);
        }

        boolean isValid(Set<Integer> query, int answer) {
            int count = 0;
            for (int num : code) {
                if (query.contains(num)) {
                    count++;
                }
            }
            return count == answer;
        }
    }
}
