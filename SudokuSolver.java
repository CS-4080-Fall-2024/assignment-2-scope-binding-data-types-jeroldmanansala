class Solution {
        public static void main(String[] args) {
            char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
    
            Solution solution = new Solution();
            solution.solveSudoku(board);
    
        }

    public boolean solve(char[][] board, int row, int col) {
    // If last row is reached, board is done
    if (row == 9) {
        return true;
    }

    // If end of row is reached
    if (col == 9) {
        return solve(board, row + 1, 0); // Go to next row
    }

    // If current cell is filled 
    if (board[row][col] != '.') {
        return solve(board, row, col + 1); // Go to next cell
    }

    // Loop to place numbers in cells
    for (char num = '1'; num <= '9'; num++) {
        // If num cannot be placed
        if (!canPlace(board, num, row, col)) {
            continue;  // Check next num
        }

        // Place num
        board[row][col] = num;

        // Go to next cell
        if (solve(board, row, col + 1)) {
            return true;
        }

        // Backtrack if the placed number is not correct solution
        board[row][col] = '.';
    }

    return false;
}

    public boolean canPlace(char[][] board, char num, int row, int col) {

        // Starting index for 3x3 subgrid
        int subGridRow = (row / 3) * 3;
        int subGridCol = (col / 3) * 3;

        // Check if num is already present in subgrid
        for (int i = subGridRow; i < subGridRow + 3; i++) { // For row
            for (int j = subGridCol; j < subGridCol + 3; j++) { // For col
                if (board[i][j]==num) // False if num is present
                    return false;
            }
        }

        // Check if num is already present in row/col
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) 
                return false;
        }

        // Return true if num can be placed
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}
