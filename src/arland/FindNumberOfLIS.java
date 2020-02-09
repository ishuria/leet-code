package arland;

/**
 * @author xiangchaolei
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        if(0 == n){
            return 0;
        }
        //d[i]代表以i结尾的最长递增子字符串的长度
        int[] d = new int[n+1];
        //p[i]代表以i结尾的最长递增子字符串的个数
        int[] p = new int[n+1];

        int totalMax = 0;
        for (int i = 1; i <=n ; i++) {
            int max = 1;
            for (int j = i-1; j >=1 ; j--) {
                //如果i>j
                if(nums[i-1]>nums[j-1]){
                    max = Math.max(max,d[j]+1);
                }
            }

            d[i] = max;
            if(max==1){
                p[i]=1;
            }
            else{
                for (int j = i-1; j >=1 ; j--) {
                    //如果i>j
                    if(nums[i-1]>nums[j-1]&&d[j]+1==max){
                        p[i]+=p[j];
                    }
                }
            }
            totalMax = Math.max(max,totalMax);
        }

        for (int i = 1; i <=n ; i++) {
            System.out.print(d[i]+" ");
        }
        System.out.println();


        for (int i = 1; i <=n ; i++) {
            System.out.print(p[i]+" ");
        }
        System.out.println();


        int count = 0;
        for (int i = 1; i <=n ; i++) {
            //如果以i结尾的是最长字符串，统计以i结尾的数量
            if(d[i]==totalMax){
                count+=p[i];
            }

        }

        return count;
    }


    public static void main(String[] args) {
        int[] a1 = new int[]{1,3,5,4,7};
        int[] a2 = new int[]{2,2,2,2,2};
        int[] a3 = {1,2,4,3,5,4,7,2};
        // write your code here
        FindNumberOfLIS a = new FindNumberOfLIS();
        System.out.println(a.findNumberOfLIS(a1));//2
        System.out.println(a.findNumberOfLIS(a2));//5
        System.out.println(a.findNumberOfLIS(a3));//3
    }
}
