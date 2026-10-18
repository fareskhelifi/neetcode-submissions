class Solution {
    private static final int INF = 2147483647;
    private static final int[][] destinations = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[ROWS][COLS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                }
            }
        }

        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int cr = curr[0], cc = curr[1];
                grid[cr][cc] = distance;
                for (int[] dest : destinations) {
                    int nr = cr + dest[0], nc = cc + dest[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS
                        && grid[nr][nc] != -1 && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            q.offer(new int[] {nr, nc});
                        }
                }
            }
            distance++;
        }
    }
}
