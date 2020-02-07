package arland;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xiangchaolei
 */
public class MaxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (arr1, arr2) -> {
            if (arr1[0] == arr2[0]) {
                return arr2[1] - arr1[1];
            } else {
                return arr1[0] - arr2[0];
            }
        });
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i){
            secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        if(0 == n){
            return 0;
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }


        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    if(max<dp[j]){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if(max<dp[i]){
                max = dp[i];
            }
        }
        return max;
    }

    private boolean enclose(int[] a,int[] b){
        return a[0]<b[0]&&a[1]<b[1];
    }

    public static void main(String[] args) {
        // write your code here


        int[][] a1 = {
                {5,4},
                {6,4},
                {6,7},
                {2,3},
        };

        int[][] a2 = {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};

        MaxEnvelopes a = new MaxEnvelopes();
        System.out.println(a.maxEnvelopes(a1));
        System.out.println(a.maxEnvelopes(a2));
    }
}
