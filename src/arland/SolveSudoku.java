package arland;

import java.util.*;

/**
 * @author xiangchaolei
 */
public class SolveSudoku {


    public void solveSudoku(char[][] board) {

        boolean[][] rowSet = new boolean[9][9];
        boolean[][] colSet = new boolean[9][9];
        boolean[][] blockSet = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int index = board[i][j] - '1';
                    rowSet[i][index] = true;
                    colSet[j][index] = true;
                    blockSet[i/3*3+j/3][index] = true;
                }
            }
        }
        innerSolve(board, rowSet, colSet, blockSet, 0, 0);
    }

    private boolean innerSolve(char[][] board,
                               boolean[][] rowSet,
                               boolean[][] colSet,
                               boolean[][] blockSet,
                               int s, int m
                               ){
        if(m == board.length){
            m=0;
            s++;
            if(s==board.length){
                return true;
            }
        }
        //place char at s,m
        if(board[s][m]=='.'){
            for (int i = 0; i < 9; i++) {
                char c = (char)('1'+i);
                if(!rowSet[s][i]
                        &&!colSet[m][i]
                        &&!blockSet[s/3*3+m/3][i]){
                    //try solve
                    rowSet[s][i]=true;
                    colSet[m][i]=true;
                    blockSet[s/3*3+m/3][i]=true;

                    board[s][m] = c;

                    if(innerSolve(board, rowSet, colSet, blockSet, s, m+1)){
                        return true;
                    }
                    else{
                        board[s][m] = '.';
                        rowSet[s][i]=false;
                        colSet[m][i]=false;
                        blockSet[s/3*3+m/3][i]=false;
                    }
                }
            }
        }
        else{
            return innerSolve(board, rowSet, colSet, blockSet, s, m+1);
        }
        return false;
    }

    public static void main(String[] args) {
        // write your code here

//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.println();
//                System.out.print("row : "+(i+1)+" ");
//                System.out.print("col : "+(j+1)+" ");
//                System.out.print("blo : "+(i/3*3+1+j/3)+" ");
//            }
//        }

        char[][] c = new char[][]{
                new char[]{'5','3','.','.','7','.','.','.','.'},
                new char[]{'6','.','.','1','9','5','.','.','.'},
                new char[]{'.','9','8','.','.','.','.','6','.'},
                new char[]{'8','.','.','.','6','.','.','.','3'},
                new char[]{'4','.','.','8','.','3','.','.','1'},
                new char[]{'7','.','.','.','2','.','.','.','6'},
                new char[]{'.','6','.','.','.','.','2','8','.'},
                new char[]{'.','.','.','4','1','9','.','.','5'},
                new char[]{'.','.','.','.','8','.','.','7','9'},
        };

        SolveSudoku a = new SolveSudoku();
        a.solveSudoku(c);

        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
    }
}
