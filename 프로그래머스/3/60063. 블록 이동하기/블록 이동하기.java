import java.util.*;

class Solution {
    int N;
    int[][] map;
    Queue<Robot> q;
    boolean[][][] visited;
    
    public int solution(int[][] board) {
        N = board.length;
        map = new int[N + 2][N + 2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i + 1][j + 1] = 1 - board[i][j];
            }
        }
        
        int answer = 0;
        visited = new boolean[2][N + 2][N + 2];
        q = new ArrayDeque<>();
        
        addQueue(1, 2, 0);
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Robot cur = q.poll();
                if (cur.r == N && cur.c == N) {
                    return answer;
                }
                if (cur.v == 0) {
                    if (map[cur.r][cur.c - 2] == 1) {
                        addQueue(cur.r, cur.c - 1, 0);
                    }
                    if (map[cur.r][cur.c + 1] == 1) {
                        addQueue(cur.r, cur.c + 1, 0);
                    }
                    for (int i = 0; i < 2; i++) {
                        
                        int r = cur.r + i;
                        int c1 = cur.c - 1;
                        int c2 = cur.c;
                        if (map[r - 1 + i][c1] == 1 && map[r - 1 + i][c2] == 1) {
                            addQueue(r, c1, 1);
                            addQueue(r, c2, 1);
                            addQueue(r - 1 + i, cur.c, 0);
                        }
                    }
                } else {
                    if (map[cur.r - 2][cur.c] == 1) {
                        addQueue(cur.r - 1, cur.c, 1);
                    }
                    if (map[cur.r + 1][cur.c] == 1) {
                        addQueue(cur.r + 1, cur.c, 1);
                    }
                    for (int i = 0; i < 2; i++) {
                        
                        int c = cur.c + i;
                        int r1 = cur.r - 1;
                        int r2 = cur.r;
                        if (map[r1][c - 1 + i] == 1 && map[r2][c - 1 + i] == 1) {
                            addQueue(r1, c, 0);
                            addQueue(r2, c, 0);
                            addQueue(cur.r, c - 1 + i, 1);
                        }
                    }
                }
            }
            answer++;
        }
        
        return answer;
    }
    
    void addQueue(int r, int c, int v) {
        if (visited[v][r][c]) {
            return;
        }
        q.add(new Robot(r, c, v));
        visited[v][r][c] = true;
    }
    
    class Robot {
        int r, c;
        int v; // 0 : row, 1 : col
        
        Robot(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
}