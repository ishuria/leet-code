package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class Rob2 {

    public int rob(int[] nums) {
        int n = nums.length;
        if(0 == n){
            return 0;
        }
        return Math.max(
                rob1(Arrays.copyOfRange(nums, 1, n)),//没偷第一家
                rob1(Arrays.copyOfRange(nums, 2, n-1)) + nums[0]);//偷了第一家
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        if(0 == n){
            return 0;
        }
        if(1 == n){
            return nums[0];
        }
        if(2 == n){
            return Math.max(nums[0], nums[1]);
        }
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            if(0 == i){
                d[i] = nums[i];
            }
            else if(1 == i){
                d[i] = Math.max(nums[0], nums[1]);
            }
            else{
                d[i] = Math.max(d[i-1], d[i-2]+nums[i]);
            }
        }
        return d[n-1];
    }

    public static void main(String[] args) {
        // write your code here
        int[] a1 = new int[]{2,3,2};
        int[] a2 = new int[]{1,2,3,1};
        int[] a3 = new int[]{1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
        Rob2 a = new Rob2();
        System.out.println(a.rob(a1));
        System.out.println(a.rob(a2));
        System.out.println(a.rob(a3));
    }
}
