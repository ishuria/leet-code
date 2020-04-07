package arland;

/**
 * @author xiangchaolei
 */
public class RemoveElement27 {


    public int removeElement(int[] nums, int val) {


        int i = 0;

        int n = nums.length;
        for (int k = 0; k < n; k++) {
            if(nums[k]==val){
            }
            else{
                nums[i]=nums[k];
                i++;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        // write your code here

        int[] nums1 = {3,2,2,3};
        int val1 = 3;
        RemoveElement27 a = new RemoveElement27();

        System.out.println(a.removeElement(nums1, val1));

    }
}
