package arland;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangchaolei
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums[Math.abs(nums[i])-1] *= -1;
            if(nums[Math.abs(nums[i])-1]>0){
                ret.add(Math.abs(nums[i]));
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        // write your code here

        FindDuplicates a = new FindDuplicates();
        System.out.println(a.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));



    }
}
