package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class WiggleSort324 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = nums[i];
        }
        qsort(d,0,n-1);
        if(n%2==0){
//            swap(d,0,n/2-1);
//            swap(d,n-1,n/2);
            for (int i = 0; i <n/2 ; i++) {
                //0 1, 2 3, 4 5
                nums[i*2] = d[n/2-i];
                nums[i*2+1] = d[n-1-i];
            }
        }
        else{
            for (int i = 0; i <(n)/2 ; i++) {
                //0 1, 2 3, 4 5
                nums[i*2] = d[n/2-i];
                nums[i*2+1] = d[n-1-i];
            }
            nums[n-1] = d[0];
        }
        return;
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private double findMid(int[] nums){
        int n = nums.length;
        if(n%2==0){

            int low = 0, high = n-1;
            int a = partition(nums, low, high);
            while(a!=n/2){
                if(a>n/2){
                    high = a-1;
                }
                else{
                    low = a+1;
                }
                a = partition(nums, low, high);
            }
            int max = 0;
            for (int i = 0; i <n/2 ; i++) {
                max = Math.max(max, nums[i]);
            }
            return ((double)nums[a] + (double)max) / 2;

        }
        else{
            int low = 0, high = n-1;
            int a = partition(nums, low, high);
            while(a!=n/2){
                if(a>n/2){
                    high = a-1;
                }
                else{
                    low = a+1;
                }
                a = partition(nums, low, high);
            }
            return nums[a];
        }
    }

    private int partition(int[] a, int low, int high){
        int t = a[low];
        while(low<high){
            while(low<high&&a[high]>=t)high--;
            a[low]=a[high];
            while(low<high&&a[low]<=t)low++;
            a[high]=a[low];
        }
        a[low]=t;
        return low;
    }

    private void qsort(int[] a, int low, int high){
        if(low<high){
            int p = partition(a,low,high);
            qsort(a,low,p-1);
            qsort(a,p+1,high);
        }
    }


    public static void main(String[] args) {
        // write your code here
        WiggleSort324 a = new WiggleSort324();
//        a.wiggleSort(new int[]{1,5,1,4,6});
//        a.wiggleSort(new int[]{1,3,2,2,3,1,1});


//        int[] a2 = new int[]{4,5,5,6};
//        a.wiggleSort(a2);
//        System.out.println(Arrays.toString(a2));//[1,2,1,2,1,2,1]
//
//        int[] a3 = new int[]{1,1,2,1,2,2,1};
//        a.wiggleSort(a3);
//        System.out.println(Arrays.toString(a3));//[1,2,1,2,1,2,1]
//
//
//        int[] a4 = new int[]{1,5,1,1,6,4};
//        a.wiggleSort(a4);//[1,6,1,5,1,4]
//        System.out.println(Arrays.toString(a4));
//        int[] a5 = new int[]{1,2,2,1,2,1,1,1,2,2,1,2,1,2,1,1,2};
//        a.wiggleSort(a5);//[1,6,1,5,1,4]
//        System.out.println(Arrays.toString(a5));
//
//        int[] a6 = new int[]{1,2,2,1,2,1,1,1,1,2,2,2};
//        a.wiggleSort(a6);//[1,6,1,5,1,4]
//        System.out.println(Arrays.toString(a6));
//
//        //1122 2233
//        int[] a7 = new int[]{2,3,3,2,2,2,1,1};
//        a.wiggleSort(a7);//[1,6,1,5,1,4]
//        System.out.println(Arrays.toString(a7));
//
//
        //[2,1,1,2,1,3,3,3,1,3,1,3,2]
        //111112 2 233333
        int[] a8 = new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2};
        a.wiggleSort(a8);//[2,3,2,3,1,3,1,3,1,3,1,2,1]
        System.out.println(Arrays.toString(a8));

        //[5,3,1,2,6,7,8,5,5]
        //12355 5678
        //585736251
        int[] a9 = new int[]{5,8,5,7,3,6,2,5,1};
        a.wiggleSort(a9);//[5,8,5,7,3,6,2,5,1]
        System.out.println(Arrays.toString(a9));
    }
}
