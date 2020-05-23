package arland;

/**
 * @author xiangchaolei
 */
public class MinHeightShelves1105 {

    public int minHeightShelves(int[][] books, int shelf_width) {

        int n = books.length;
        int[] dp = new int[n];

        dp[0] = books[0][1];

        for (int i = 1; i < n; i++) {
            int height = books[i][1];
            int width = books[i][0];
            dp[i] = height + dp[i-1];
            for (int j = i-1; j >= 0; j--) {
                width += books[j][0];
                if(width>shelf_width){
                    break;
                }
                height = Math.max(height, books[j][1]);
                if(j==0){
                    dp[i] = height;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j-1]+height);
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        // write your code here
        MinHeightShelves1105 a = new MinHeightShelves1105();
        System.out.println(a.minHeightShelves(
                new int[][]{
                        new int[]{1,1},
                        new int[]{2,3},
                        new int[]{2,3},
                        new int[]{1,1},
                        new int[]{1,1},
                        new int[]{1,1},
                        new int[]{1,2}
                }, 4
        ));
    }
}
