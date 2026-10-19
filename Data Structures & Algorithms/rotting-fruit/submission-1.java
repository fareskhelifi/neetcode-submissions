class Solution {
    private static final int[][] destinations = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int ROWS = grid.length, COLS = grid[0].length;

        int fresh = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        int minutes = 0;

        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                for (int[] dest : destinations) {
                    int nr = curr[0] + dest[0], nc = curr[1] + dest[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS
                        && grid[nr][nc] == 1) {
                            fresh--;
                            grid[nr][nc] = 2;
                            q.offer(new int[] {nr, nc});
                        }
                }
            }
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
