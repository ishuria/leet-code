package arland;

/**
 * @author xiangchaolei
 */
public class CountSort {

    public static void  main(String[] args){
        int[] nums={2,3,4,1,2,4,3,1,2,2,1};
        CountSort sort=new CountSort();
        sort.indecCountIndex(nums);
    }

    public void indecCountIndex(int[] nums){
        int[] count=new int[6];
        for(int i=0;i<nums.length;i++){
            count[nums[i]+1]++;
        }
        for(int i=1;i<count.length;i++){
            count[i]=count[i]+count[i-1];
        }
        int[] aux=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            aux[count[nums[i]]++]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(aux[i]+" ");
        }
    }
}
