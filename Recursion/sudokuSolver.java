package Recursion;

/*Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
1. Each of the digits 1-9 must occur exactly once in each row.
2. Each of the digits 1-9 must occur exactly once in each column.
3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.*/

public class sudokuSolver {
    public static boolean isSafe(char[][]board, int row, int col, int number){
        //column
        for(int i=0;i<board.length;i++){
            if(board[i][col] == (char)(number+'0')){
                return false;
            }
        }
        //column
        for(int j=0;j<board.length;j++){
            if(board[row][j] == (char)(number+'0')){
                return false;
            }
        }
        //grid
        int sr = 3*(row/3);
        int sc = 3*(col/3);
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(board[i][j] == (char)(number+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean helper(char[][]board, int row, int col){
        if(row == board.length){
            return true;
        }
        int newRow = 0;
        int newCol = 0;
        if(col == board.length-1){
            newRow = row + 1;
            newCol = 0;
        }else{
            newRow = row;
            newCol = col + 1;
        }
        if(board[row][col] != '.'){
            if(helper(board,newRow,newCol))
                return true;
        }else{
            //fill the place 
            for(int i=1; i<=9; i++){
                if(isSafe(board,row,col,i)){
                    board[row][col] = (char)(i+'0');
                    if(helper(board,newRow,newCol)){
                        return true;
                    }else{
                        board[row][col] = '.'; //backtrack  
                    }
                }
            }
            return false;
        }
        return false;
    }
    public static void SudokuSolver(char[][]board){
        helper(board,0,0);
    }
    // Helper method to display the grid cleanly
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
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

        SudokuSolver(board);
        printBoard(board);
    }
}
    
