package arland;

/**
 * @author xiangchaolei
 */
public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new  boolean[9][9];
        boolean[][] columns = new  boolean[9][9];
        boolean[][] subs = new  boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                else{
                    int index = board[i][j] - '1';
                    if(rows[i][index]){
                        return false;
                    }
                    else{
                        rows[i][index] = true;
                    }
                    if(columns[j][index]){
                        return false;
                    }
                    else{
                        columns[j][index] = true;
                    }

                    int subIndex = j / 3 + i / 3 * 3 + 1;
                    if(subs[subIndex-1][index]){
                        return false;
                    }
                    else{
                        subs[subIndex-1][index] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here
        
        char[][] a1 = {
                      {'5','3','.','.','7','.','.','.','.'},
                      {'6','.','.','1','9','5','.','.','.'},
                      {'.','9','8','.','.','.','.','6','.'},
                      {'8','.','.','.','6','.','.','.','3'},
                      {'4','.','.','8','.','3','.','.','1'},
                      {'7','.','.','.','2','.','.','.','6'},
                      {'.','6','.','.','.','.','2','8','.'},
                      {'.','.','.','4','1','9','.','.','5'},
                      {'.','.','.','.','8','.','.','7','9'}
                    };

        IsValidSudoku a = new IsValidSudoku();

        System.out.println(a.isValidSudoku(a1));

    }
}
