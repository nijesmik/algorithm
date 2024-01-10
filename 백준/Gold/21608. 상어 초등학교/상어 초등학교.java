import java.util.*;

public class Main {
    static int mapSize, studentSize;
    static Seat[][] map;
    static Student[] students;
    static Map<Integer, Set<Integer>> preference;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mapSize = sc.nextInt();
        map = new Seat[mapSize][mapSize];
        for (int r = 0; r < mapSize; r++) {
            for (int c = 0; c < mapSize; c++) {
                map[r][c] = new Seat(r, c);
            }
        }

        studentSize = mapSize * mapSize;
        students = new Student[studentSize + 1];
        preference = new HashMap<>();
        int[] keys = new int[studentSize];
        for (int i = 0; i < studentSize; i++) {
            keys[i] = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                set.add(sc.nextInt());
            }
            preference.put(keys[i], set);
        }

        for (int key : keys) {
            setScore(key);
            deriveSeat(key);
            for (int r = 0; r < mapSize; r++) {
                for (int c = 0; c < mapSize; c++) {
                    map[r][c].score = 0;
                }
            }
        }

        System.out.println(deriveAnswer());
    }

    static int deriveAnswer() {
        int ans = 0;
        for (int r = 0; r < mapSize; r++) {
            for (int c = 0; c < mapSize; c++) {
                Set<Integer> set = preference.get(map[r][c].studentNumber);
                int count = 0;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i], nc = c + dc[i];
                    if (nr >= 0 && nr < mapSize && nc >= 0 && nc < mapSize) {
                        if (set.contains(map[nr][nc].studentNumber))
                            count++;
                    }
                }
                if (count > 0) {
                    ans += (int) Math.pow(10, count - 1);
                }
            }
        }
        return ans;
    }

    static void deriveSeat(int idx) {
        PriorityQueue<Seat> pq = new PriorityQueue<>();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                pq.add(map[i][j]);
            }
        }
        while (!pq.isEmpty()) {
            Seat cur = pq.poll();
            if (cur.studentNumber == 0) {
                cur.studentNumber = idx;
                students[idx] = new Student(cur.r, cur.c);
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i], nc = cur.c + dc[i];
                    if (nr >= 0 && nr < mapSize && nc >= 0 && nc < mapSize) {
                        map[nr][nc].nearEmpty--;
                    }
                }
                return;
            }
        }
    }

    static void setScore(int key) {
        Set<Integer> value = preference.get(key);
        for (int loverIndex : value) {
            Student lover = students[loverIndex];
            if (lover != null) {
                for (int j = 0; j < 4; j++) {
                    int nr = lover.r + dr[j], nc = lover.c + dc[j];
                    if (nr >= 0 && nr < mapSize && nc >= 0 && nc < mapSize) {
                        map[nr][nc].score++;
                    }
                }
            }
        }
    }

    static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };

    static class Seat implements Comparable<Seat> {
        int studentNumber, nearEmpty, r, c, score;

        Seat(int r, int c) {
            this.r = r;
            this.c = c;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                if (nr >= 0 && nr < mapSize && nc >= 0 && nc < mapSize) {
                    nearEmpty++;
                }
            }
        }

        @Override
        public int compareTo(Seat o) {
            if (this.score != o.score)
                return o.score - this.score;
            if (this.nearEmpty != o.nearEmpty)
                return o.nearEmpty - this.nearEmpty;
            if (this.r != o.r)
                return this.r - o.r;
            return this.c - o.c;
        }
    }

    static class Student {
        int r, c;

        Student(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
