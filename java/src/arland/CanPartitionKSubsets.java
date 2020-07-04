package arland;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class CanPartitionKSubsets {


    public boolean canPartitionKSubsets(int[] nums, int k) {


        int sum = Arrays.stream(nums).sum();

        if(sum % k > 0){
            return false;
        }
        int target = sum / k;

        Arrays.sort(nums);

        int n = nums.length;
        if(nums[n-1]>target){
            return false;
        }


        int[] partitions = new int[k];

        return tryPlace(partitions, n-1, nums, target);

    }

    public boolean tryPlace(int[] partitions, int index, int[] nums, int target){
        if(index<0){
            System.out.println(Arrays.toString(partitions));
            return true;
        }
        //放置v这个数字
        int v = nums[index];

        int n = partitions.length;
        for (int i = 0; i < n; i++) {
            //尝试将v放入partitions[i]
            if(partitions[i] + v > target){
                //不放，尝试下一个
            }
            else{
                //partitions[i] + v <= target
                partitions[i] += v;

                //递归尝试下一个数字
                if(tryPlace(partitions, index-1, nums, target)){
                    System.out.println(Arrays.toString(partitions));
                    return true;
                }
                else{
                    //
                    partitions[i] -= v;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        // write your code here

        int[] nums1 = {4, 3, 2, 3, 5, 2, 1,4,4,4,3};
        int k1 = 4;


        CanPartitionKSubsets a = new CanPartitionKSubsets();
        System.out.println(a.canPartitionKSubsets(nums1, k1));
    }
}
