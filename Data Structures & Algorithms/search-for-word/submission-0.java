class Solution {
    private int ROWS, COLS;
    private Set<Pair<Integer, Integer>> path = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (backtrack(row, col, 0, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, int i, char[][] board, String word) {
        
        if (i == word.length()) return true;

        if (row < 0 || col < 0 || row >= ROWS || col >= COLS
            || word.charAt(i) != board[row][col] 
            || path.contains(new Pair<>(row, col))) {
                return false;
            }

        path.add(new Pair<>(row, col));


        boolean result = backtrack(row + 1, col, i + 1, board, word) ||
                         backtrack(row - 1, col, i + 1, board, word) ||
                         backtrack(row, col + 1, i + 1, board, word) ||
                         backtrack(row, col - 1, i + 1, board, word);
        path.remove(new Pair<>(row, col));
        return result;
    }
}
