class Solution {
    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int result = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    result++;
                }
            }
        }  
        return result;  
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        grid[r][c] = '0';

        int rows = grid.length, cols = grid[0].length;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int[] dir : directions) {
                int row = node[0] + dir[0], col = node[1] + dir[1];
                if (row >= 0 && row < rows 
                    && col >= 0 && col < cols 
                    && grid[row][col] == '1'
                    ) 
                {
                    q.offer(new int[]{row, col});
                    grid[row][col] = '0';
                }
            }
        }   
    }
}
