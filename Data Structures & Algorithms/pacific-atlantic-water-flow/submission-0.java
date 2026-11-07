class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS;
    private int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length; 
        COLS = heights[0].length;
        
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (bfs(r, c, heights)) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private boolean bfs(int r, int c, int[][] heights) {
        boolean[][] visited = new boolean[ROWS][COLS];
        boolean isAtlantic = false;
        boolean isPacific = false;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int size = q.size();
        
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int cr = node[0], cc = node[1];
                for (int[] dir : DIRECTIONS) {
                    int nr = cr + dir[0], nc = cc + dir[1];
                    if (nr < 0 || nc < 0) {
                        isPacific = true;
                    }
                    if (nr == ROWS || nc == COLS) {
                        isAtlantic = true;
                    }
                    if (isAtlantic && isPacific) return true;

                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS 
                        && heights[cr][cc] >= heights[nr][nc] && !visited[nr][nc]) {
                            q.offer(new int[] {nr, nc});
                            visited[nr][nc] = true;
                        }
                    
                }
            }
        }
        return (isPacific && isAtlantic);
    }
}
