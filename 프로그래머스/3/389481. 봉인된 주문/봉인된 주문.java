import java.util.*;

public class Solution {
    public String solution(long n, String[] bans) {
        List<Long> bannedNums = new ArrayList<>();
        for (String ban : bans) {
            long num = spellToNum(ban);
            bannedNums.add(num);
        }
        bannedNums.sort(Comparator.naturalOrder());

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
