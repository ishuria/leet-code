package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class ThreeSumClosest16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;
            int t = target-nums[i];
            while(j<k){
                if(Math.abs(t-nums[j]-nums[k])<diff){
                    diff = Math.abs(t-nums[j]-nums[k]);
                    sum = nums[i]+nums[j]+nums[k];
                }
                if(nums[j]+nums[k]<t){
                    j++;
                }
                else if(nums[j]+nums[k]>t){
                    k--;
                }
                else{
                    return nums[i]+nums[j]+nums[k];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // write your code here
        ThreeSumClosest16 a = new ThreeSumClosest16();
        System.out.println(a.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(a.threeSumClosest(new int[]{0,1,2}, 3));
        //-4 -1 1 2
    }
}
