package arland;

/**
 * @author xiangchaolei
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        System.out.print(n + "  ");
        int[][] d = new int[n][n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(0 == i && 0 == j){
                    d[i][j] = 1;
                }
                else if(0 == i){
                    d[i][j] = d[i][j-1];
                }
                else if(0 == j){
                    d[i][j] = d[i-1][j];
                }
                else{
                    d[i][j] = d[i-1][j] + d[i][j-1];
                }
                if(2 * j + i == n){
                    sum += d[i][j];
                }
            }
        }
        return sum + 1;
    }

    public static void main(String[] args) {
        ClimbStairs a = new ClimbStairs();
        System.out.println(a.climbStairs(0));
        System.out.println(a.climbStairs(1));
        System.out.println(a.climbStairs(2));
        System.out.println(a.climbStairs(3));
        System.out.println(a.climbStairs(4));
        System.out.println(a.climbStairs(5));
    }
}
