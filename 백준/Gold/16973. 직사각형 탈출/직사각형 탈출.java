import java.util.*;

class Main {

    static int boardR, boardC, board[][], height, width, startR, startC, endR, endC;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boardR = sc.nextInt();
        boardC = sc.nextInt();
        board = new int[boardR][boardC];
        for (int i = 0; i < boardR; i++) {
            for (int j = 0; j < boardC; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        height = sc.nextInt();
        width = sc.nextInt();
        startR = sc.nextInt() - 1;
        startC = sc.nextInt() - 1;
        endR = sc.nextInt() - 1;
        endC = sc.nextInt() - 1;
        System.out.println(bfs());
    }

    static int bfs() {
        visited = new boolean[boardR][boardC];
        Queue<Record> q = new LinkedList<>();
        q.add(new Record(startR, startC, 0));

        while (!q.isEmpty()) {
            Record cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i], nc = cur.c + dc[i];
                if (nr == endR && nc == endC) {
                    return cur.time + 1;
                }
                if (canGo(nr, nc)) {
                    q.add(new Record(nr, nc, cur.time + 1));
                }
            }
        }
        return -1;
    }

    static boolean canGo(int r, int c) {
        if (r < 0 || c < 0 || r + height - 1 >= boardR || c + width - 1 >= boardC
            || visited[r][c]) {
            return false;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[r + i][c + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Record {

        int r, c, time;

        public Record(int r, int c, int time) {
            visited[r][c] = true;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}