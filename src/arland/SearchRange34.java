package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class SearchRange34 {

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int i = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                i=mid;
                break;
            }
            if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if(i==-1){
            return new int[]{-1,-1};
        }
        else{
            int j=i,k=i;
            while(j>=0&&nums[j]==target){
                j--;
            }
            while(k<=nums.length-1&&nums[k]==target){
                k++;
            }
            return new int[]{j<0?0:j+1,k>=nums.length?nums.length-1:k-1};
        }
    }

    public static void main(String[] args) {
        // write your code here
        SearchRange34 a = new SearchRange34();
        System.out.println(Arrays.toString(a.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(a.searchRange(new int[]{5,7,7,8,8,10}, 6)));
    }
}
