package arland;


/**
 * @author xiangchaolei
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int[] dp = new  int[n+1];
        dp[1] = 1;


        int i2 = 1;
        int i3 = 1;
        int i5 = 1;



        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i2]*2, Math.min(dp[i3]*3, dp[i5]*5));
            if(dp[i] % 2 == 0){
                i2++;
            }
            if(dp[i] % 3 == 0){
                i3++;
            }
            if(dp[i] % 5 == 0){
                i5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // write your code here
        NthUglyNumber a = new NthUglyNumber();
        System.out.println(a.nthUglyNumber(10));
        System.out.println(a.nthUglyNumber(103));
        System.out.println(a.nthUglyNumber(1352));
        System.out.println(a.nthUglyNumber(1690));
    }
}
