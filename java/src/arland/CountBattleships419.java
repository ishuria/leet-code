package arland;

/**
 * @author xiangchaolei
 */
public class CountBattleships419 {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if(i==0&&j==0){
                    if(c=='X'){
                        count++;
                    }
                }
                else if(i==0){
                    if(c=='X'&&board[i][j-1]!='X'){
                        count++;
                    }
                }
                else if(j==0){
                    if(c=='X'&&board[i-1][j]!='X'){
                        count++;
                    }
                }
                else{
                    if(c=='X'&&board[i-1][j]!='X'&&board[i][j-1]!='X'){
                        count++;
                    }
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        // write your code here

        char[][] a1 = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        CountBattleships419 a = new CountBattleships419();
        System.out.println(a.countBattleships(a1));
    }

}
