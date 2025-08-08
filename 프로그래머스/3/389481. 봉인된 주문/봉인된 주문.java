import java.util.*;
import java.util.stream.*;

public class Solution {
    public String solution(long n, String[] bans) {
        List<Long> bannedNums = Arrays.stream(bans)
                .mapToLong(this::spellToNum)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        for (long num : bannedNums) {
            if (num <= n) {
                n++;
            }
        }

        String answer = "";
        while (n > 0) {
            char letter = (char) ('a' + (n - 1) % 26);
            answer = letter + answer;
            n = (n - 1) / 26;
        }
        return answer;
    }

    long spellToNum(String spell) {
        char[] chars = spell.toCharArray();
        long num = 0;
        for (char c : chars) {
            num = num * 26 + c - 'a' + 1;
        }
        return num;
    }
}
