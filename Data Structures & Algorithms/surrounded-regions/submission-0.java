class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS;
    private int COLS;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (!visited[r][c] && board[r][c] == 'O') {
                    bfs(r, c, board, visited);
                }
                
            }
        }
        
    }

    private void bfs(int r, int c, char[][] board, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        visited[r][c] = true;

        Set<int[]> regionsCoordinates = new HashSet<>();
        regionsCoordinates.add(new int[] {r, c});

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int cr = node[0], cc = node[1];
                for (int[] dir : DIRECTIONS) {
                    int nr = cr + dir[0], nc = cc + dir[1];
                    if(nr < ROWS && nr >= 0 && nc < COLS && nc >= 0
                        && !visited[nr][nc] && board[nr][nc] == 'O') {
                            q.offer(new int[] {nr, nc});
                            regionsCoordinates.add(new int[] {nr, nc});
                            visited[nr][nc] = true;
                        }

                }
            }
        }

        boolean isSurrounded = true;
        for (int[] node : regionsCoordinates) {
            if (node[0] == 0 || node[0] == ROWS - 1 || node[1] == 0 || node[1] == COLS -1) {
                isSurrounded = false;
                break;
            }
        }

        if (isSurrounded) {
            for (int[] node : regionsCoordinates) {
                board[node[0]][node[1]] = 'X';
            }
        }
    }
}
