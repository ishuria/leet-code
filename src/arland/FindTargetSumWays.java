package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;

        if(1==n){
            if(S == nums[0]&&S == -nums[0]){
                return 2;
            }
            if(S == nums[0]){
                return 1;
            }
            if(S == -nums[0]){
                return 1;
            }
            return 0;
        }

        int sum = 0;
        sum+= findTargetSumWays(Arrays.copyOfRange(nums, 1,n),S-nums[0]);
        sum+= findTargetSumWays(Arrays.copyOfRange(nums, 1,n),S+nums[0]);
        return sum;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 1, 1, 1, 1};
        int s1 = 3;


        int[] a2 = {1,0};
        int s2 = 1;


        // write your code here
        FindTargetSumWays a = new FindTargetSumWays();
        System.out.println(a.findTargetSumWays(a1,s1));//5
        System.out.println(a.findTargetSumWays(a2,s2));//2
    }
}
