class Solution {
    int[] diffs, times;

    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        
        int maxDiff = 0;
        for (int diff : diffs) {
            maxDiff = Math.max(maxDiff, diff);
        }

        int start = 1;
        int end = maxDiff;
        while (start < end) {
            int mid = (start + end) / 2;
            long time = computeTime(mid);

            if (time <= limit) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    long computeTime(int level) {
        long total = times[0];

        for (int i = 1; i < diffs.length; i++) {
            int diff = diffs[i];
            int time = times[i];

            if (level >= diff) {
                total += time;
            } else {
                total += (time + times[i - 1]) * (diff - level) + time;
            }
        }
        return total;
    }
}