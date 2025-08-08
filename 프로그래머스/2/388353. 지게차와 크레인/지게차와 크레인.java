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
    
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, 1, -1};
    void car(char target) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[itemsRow][itemsCol];
        for (int c = 0; c < itemsCol; c++) {
            q.add(new int[]{0, c});
            visited[0][c] = true;
            
            q.add(new int[]{itemsRow - 1, c});
            visited[itemsRow - 1][c] = true;
        }
        for (int r = 1; r < itemsRow - 1; r++) {
            q.add(new int[]{r, 0});
            visited[r][0] = true;
            
            q.add(new int[]{r, itemsCol - 1});
            visited[r][itemsCol - 1] = true;
        }

        while (!q.isEmpty()) {
            int[] position = q.poll();
            int r = position[0];
            int c = position[1];
            char item = items[r][c];
            
            if (item == target) {
                items[r][c] = 0;
            } else if (item == 0) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (isValidPosition(nr,nc) && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
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