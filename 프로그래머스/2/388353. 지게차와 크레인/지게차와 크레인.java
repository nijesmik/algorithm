import java.util.*;

class Solution {
    char[][] items;
    int itemsRow, itemsCol;

    void crane(char target) {
        for (int r = 0; r < itemsRow; r++) {
            for (int c = 0; c < itemsCol; c++) {
                if (items[r][c] == target) {
                    items[r][c] = 0;
                }
            }
        }
    }


    void car(char target) {
        class BFS extends LinkedList<int[]>  {
            boolean[][] visited = new boolean[itemsRow][itemsCol];
            int[] dr = {1, -1, 0, 0};
            int[] dc = {0, 0, 1, -1};

            void add(int r, int c) {
                super.add(new int[]{r, c});
                visited[r][c] = true;
            }
            
            void addNext(int r, int c) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (isValidPosition(nr, nc) && !visited[nr][nc]) {
                        add(nr, nc);
                    }
                }
            }
        }

        BFS bfs = new BFS();

        for (int c = 0; c < itemsCol; c++) {
            bfs.add(0, c);
            bfs.add(itemsRow - 1, c);
        }
        for (int r = 1; r < itemsRow - 1; r++) {
            bfs.add(r, 0);
            bfs.add(r, itemsCol - 1);
        }

        while (!bfs.isEmpty()) {
            int[] position = bfs.poll();
            int r = position[0];
            int c = position[1];
            char item = items[r][c];

            if (item == target) {
                items[r][c] = 0;
            } else if (item == 0) {
                bfs.addNext(r, c);
            }

        }
    }

    boolean isValidPosition(int r, int c) {
        return r >= 0 && r < itemsRow && c >= 0 && c < itemsCol;
    }

    public int solution(String[] storage, String[] requests) {
        itemsRow = storage.length;
        itemsCol = storage[0].length();
        items = new char[itemsRow][itemsCol];
        for (int r = 0; r < itemsRow; r++) {
            items[r] = storage[r].toCharArray();
        }

        for (String request : requests) {
            int method = request.length();
            char target = request.charAt(0);

            if (method == 1) {
                // 지게차
                car(target);
            } else if (method == 2) {
                // 크레인
                crane(target);
            }
        }

        int answer = 0;
        for (int r = 0; r < itemsRow; r++) {
            for (int c = 0; c < itemsCol; c++) {
                if (items[r][c] != 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
