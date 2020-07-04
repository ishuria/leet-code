package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class RemoveDuplicates26 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(0==n){
            return 0;
        }
        if(1==n){
            return 1;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums1 = {1,1,2};
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicates26 a = new RemoveDuplicates26();
        System.out.println(a.removeDuplicates(nums1));//2
        System.out.println(a.removeDuplicates(nums2));//5
    }

}
