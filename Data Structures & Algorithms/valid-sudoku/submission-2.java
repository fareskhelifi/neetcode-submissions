class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (char[] row : board) {
            if (!isValidRow(row)) {
                System.out.println("invalid row: " + row);
                return false;
            };
        }

        for (int i = 0; i < 9; i++) {
            if (!isValidColumn(board, i)) {
                System.out.println("invalid column: " + i);
                return false;
            };
        }

        for (int i = 0; i < 7; i+=3) {
            for (int j = 0; j < 7; j+=3) {
                if(!isValidBox(board, i, j)) {
                    System.out.println("invalid Box: " + i + " " + j);
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidRow(char[] row) {
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            count.put(row[i], count.getOrDefault(row[i], 0) + 1);
            if (row[i] != '.' && count.get(row[i]) > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidColumn(char[][] board, int i) {
        Map<Character, Integer> count = new HashMap<>();

        for (int j = 0; j < 9; j++) {
            count.put(board[j][i], count.getOrDefault(board[j][i], 0) + 1);
            if (board[j][i] != '.' && count.get(board[j][i]) > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidBox(char[][] board, int i, int j) {
        Map<Character, Integer> count = new HashMap<>();

        for (int l = i; l < i + 3; l++) {
            for (int c = j; c < j + 3; c++) {
                count.put(board[l][c], count.getOrDefault(board[l][c], 0) + 1);
                if (board[l][c] != '.' && count.get(board[l][c]) > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
