public class NQueens{
    
      // Function to check if a queen can be placed at board[row][col]
      static boolean isSafe(int[][] board, int row, int col) {
        int N = board.length;

        // Check the row and column for another queen
        for (int i = 0; i < N; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
        }

        // Check diagonals for any queens
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j == row + col) || (i - j == row - col)) {
                    if (board[i][j] == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
   
    // Function to solve N-Queens problem
    static boolean solveNQueens(int[][] board, int row) {
        // Base case: If all queens are placed
        if (row == board.length) {
            return true;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                // Place the queen
                board[row][col] = 1;

                // Recur to place queens in the next row
                if (solveNQueens(board, row + 1)) {
                    return true;
                }

                // Backtrack: remove the queen
                board[row][col] = 0;
            }
        }

        // If the queen cannot be placed in any column in this row, return false
        return false;
    }

    // Function to print the board
    static void printBoard(int[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] board = new int[4][4];  // 4x4 board for 4 queens
        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
