package javaapplication2;

public class NewClass {

    private final int[][] board;

    // Set up game board format
    public NewClass(int[][] board) {
        // 9 x 9 board
        this.board = new int[3][3];

        // increment columns and rows of board
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[i], 0, this.board[i], 0, 3);
        }
    }

    // Check for possible numbers in rows, columns, and smaller 3x3 grid
    private boolean rowCheck(int row, int num) {
        for (int i = 0; i < 3; i++) {
            if (board[row][i] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean colCheck(int col, int num) {
        for (int i = 0; i < 3; i++) {
            if (board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean setNum(int row, int col, int num) {
        return !(rowCheck(row, num) || colCheck(col, num));
    }

    // Solve the sudoku
    public boolean solve() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == 0) {
                    // check for numbers in range
                    for (int num = 1; num <= 3; num++) {
                        if (setNum(r, c, num)) {
                            // set number if it passes all checks
                            board[r][c] = num;
                             
                            // backtrack if we run into constraints, other wise return true to finish sudoku
                            if (solve()) {
                                return true;
                            } else {
                                // reset the cell to 0 and backtrack
                                board[r][c] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        // true if solved
        return true;
    }

    // Print solved puzzle
    public void printSudoku() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // Our game board 'The hardest sudoku board' - found online
        // 2D array, empty boxes are 0

        int[][] sudokuPuzzle = {{0, 0, 0},
        {0, 0, 0},
        {0, 0, 1}};

        /*{
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 6, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 9, 0, 2, 0, 0},
            {0, 5, 0, 0, 0, 7, 0, 0, 0},
            {0, 0, 0, 0, 4, 5, 7, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 3, 0},
            {0, 0, 1, 0, 0, 0, 0, 6, 8},
            {0, 0, 8, 5, 0, 0, 0, 1, 0},
            {0, 9, 0, 0, 0, 0, 4, 0, 0},};
         */
        // getting execution time
        final long startTime = System.currentTimeMillis();
        // create new object
        NewClass sudoku = new NewClass(sudokuPuzzle);

        System.out.println("Solving this sudoku via recursion / backtracking");
        sudoku.printSudoku();

        // Run solve method
        if (sudoku.solve()) {
            System.out.println("Solved sudoku");
            final long endTime = System.currentTimeMillis();
            // print solved sudoku
            sudoku.printSudoku();
            System.out.println("Total execution time: " + (endTime - startTime) + "ms");
        } else {
            System.out.println("This sudoku cannot be solved");
        }
    }

}
