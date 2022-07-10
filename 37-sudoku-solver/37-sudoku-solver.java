class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    
     public static boolean solve(char[][] board) {
        // Going into each row and it each col and checking
        // if it is empty or not
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') { // if the col of that particular row is empty , we need to fill that cell with checking the conditions

                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) { // if it is valid to fill the cell , put cth value in that particual cell
                            board[i][j] = c;

                            if (solve(board)) // calls up for board cell which is empty and return true if all the placed is filled correctly
                                return true;
                            else
                                board[i][j] = '.'; // if not we backtrack and empty that cell
                        }
                    }

                    return false; // if it is not valid to fill the cell then return false
                }
            }
        }
        return true; // if there is no more empty cell , then return true
    }

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            //checking for , if we can put a value in that particular row or not , if not return false
            if (board[i][col] == c)
                return false;

            //checking for , if we can put a value in that particular col or not , if not return false
            if (board[row][i] == c)
                return false;

            //checking for , if we can put a value in that particular grid or not , if not return false
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true; // true means we can place that value as it is found int row , col and grid
    }
    
}