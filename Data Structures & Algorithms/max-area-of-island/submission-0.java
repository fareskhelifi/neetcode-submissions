class Solution {
    private static final int[][] destinations = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int maxArea = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    bfs(grid, r, c);
                }
            }
        }
        return maxArea;
    }

    private void bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        int currArea = 1;
        int rows = grid.length, cols = grid[0].length;

        q.offer(new int[] {r, c});
        grid[r][c] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dst : destinations) {
                int nr = node[0] + dst[0], nc = node[1] + dst[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                    && grid[nr][nc] == 1) {
                        currArea++;
                        q.offer(new int[]{nr, nc});
                        grid[nr][nc] = 0;
                    }
            }
        }

        maxArea = Math.max(maxArea, currArea);
    }
}
