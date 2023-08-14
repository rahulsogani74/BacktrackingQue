public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        char originalChar = board[row][col];
        board[row][col] = ' ';
        boolean found = backtrack(board, word, row + 1, col, index + 1)
                || backtrack(board, word, row - 1, col, index + 1)
                || backtrack(board, word, row, col + 1, index + 1)
                || backtrack(board, word, row, col - 1, index + 1);
        board[row][col] = originalChar;
        return found;
    }
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println("Word 'ABCCED' exists: " + solution.exist(board, word1));
        System.out.println("Word 'SEE' exists: " + solution.exist(board, word2));
        System.out.println("Word 'ABCB' exists: " + solution.exist(board, word3));
    }
}
