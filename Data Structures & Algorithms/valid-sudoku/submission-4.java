class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> squares = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char num = board[r][c];

                if (num == '.') continue;

                Set<Character> rowElements = rows.computeIfAbsent(r, k -> new HashSet<>());
                if (!rowElements.add(num)) return false;

                Set<Character> colElements = cols.computeIfAbsent(c, k -> new HashSet<>());
                if (!colElements.add(num)) return false;

                String key = (r/3) + "," + (c/3); 
                Set<Character> squareElements = squares.computeIfAbsent(key, k -> new HashSet<>());
                if (!squareElements.add(num)) return false;

            }
        }
        return true;
    }
}
