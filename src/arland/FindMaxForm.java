package arland;

/**
 * @author xiangchaolei
 */
public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {

        int l = strs.length;

        if(0==l){
            return 0;
        }

        //dp[i][j]代表用了i个1，j个0，所能表示的前k个字符串中的最大个数

        int[][][] dp = new int[m+1][n+1][l+1];


        //一个1都不用所能表示的数量
        for (int k = 1; k <= l; k++) {
            int length0 = numOfChars(strs[k - 1], '0');
            if(length0 != strs[k - 1].length()){
                for (int j = 1; j <= m; j++) {
                    dp[j][0][k] = dp[j][0][k-1];
                }
                continue;
            }
            for (int j = 1; j <= m; j++) {
                if(j - strs[k-1].length()>=0){
                    dp[j][0][k] = Math.max(dp[j - strs[k-1].length()][0][k-1]+1, dp[j][0][k-1]);
                }
                else{
                    dp[j][0][k] = dp[j][0][k-1];
                }
            }
        }


        //一个0都不用所能表示的数量
        for (int k = 1; k <= l; k++) {
            int length1 = numOfChars(strs[k - 1], '1');
            if(length1 != strs[k - 1].length()){
                for (int i = 1; i <= n; i++) {
                    dp[0][i][k] = dp[0][i][k-1];
                }
                continue;
            }
            for (int i = 1; i <= n; i++) {
                if(i - strs[k-1].length()>=0){
                    dp[0][i][k] = Math.max(dp[0][i - strs[k-1].length()][k-1]+1, dp[0][i][k-1]);
                }
                else{
                    dp[0][i][k] = dp[0][i][k-1];
                }
            }
        }

        for (int k = 1; k <= l; k++) {

            int length1= numOfChars(strs[k-1],'1');
            int length0= numOfChars(strs[k-1],'0');

            for (int j = 1; j <=n ; j++) {//1
                for (int i = 1; i <= m; i++) {//0

                    if(i-length0>=0&&j-length1>=0){
                        dp[i][j][k] = Math.max(dp[i-length0][j-length1][k-1]+1, dp[i][j][k-1]);
                    }
                    else{
                        dp[i][j][k] = dp[i][j][k-1];
                    }
                }
            }
        }
        return dp[m][n][l];

    }

    //统计字符串里字符的个数
    private int numOfChars(String s, char c){
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)==c){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

        String[] a1 = {"10", "0001", "111001", "1", "0"};
        int m1=5;
        int n1=3;

        String[] a2 = {"10", "0", "1"};
        int m2=1;
        int n2=1;

        String[] a3 = {"10","0001","111001","1","0"};
        int m3=4;
        int n3=3;

        // write your code here
        FindMaxForm a = new FindMaxForm();
        System.out.println(a.findMaxForm(a1,m1,n1));//4
        System.out.println(a.findMaxForm(a2,m2,n2));//2
        System.out.println(a.findMaxForm(a3,m3,n3));//3
    }
}
