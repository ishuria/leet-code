package arland;

/**
 * @author xiangchaolei
 */
public class MaxProfitAssignment826 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] diff = new int[difficulty.length][2];
        for (int i = 0; i < diff.length; i++) {
            diff[i][0] = difficulty[i];
            diff[i][1] = profit[i];
        }
        int[][] diff1 = new int[diff.length+1][2];
        System.arraycopy(diff, 0, diff1, 1, diff.length);
        hsort(diff1);

        System.arraycopy(diff1, 1, diff, 0, diff.length);
        qsort(worker, 0, worker.length-1);


        int profit1 = 0;
        for (int i = 0; i < worker.length; i++) {
            int index = 0;
            int maxP = 0;
            while(index<diff.length&&worker[i]>=diff[index][0]){
                maxP = Math.max(maxP, diff[index][1]);
                index++;
            }
            if(index>0){
                profit1+=maxP;
            }
            else if(index==0&&worker[i]>=diff[index][0]){
                profit1+=maxP;
            }
            else if(index==diff.length&&worker[i]>=diff[index-1][0]){
                profit1+=maxP;
            }
        }

        return profit1;
    }

    private void hsort(int[][] diff){
        for (int i = (diff.length-1)/2; i >=1 ; i--) {
            hadjust(diff, i, diff.length-1);
        }
        for (int i = diff.length-1; i >=1; i--) {
            swap(diff, i, 1);
            hadjust(diff, 1, i-1);
        }
    }

    private void hadjust(int[][] diff, int s, int m){
        int[] t = diff[s];
        for (int i = s*2; i <= m; i*=2) {
            if(i<m&&diff[i][0]<diff[i+1][0]){
                i++;
            }
            if(diff[i][0]<=t[0]){
                break;
            }
            diff[s] = diff[i];
            s=i;
        }
        diff[s]=t;
    }

    private void swap(int[][] diff, int i, int j){
        int[] t = diff[i];
        diff[i] = diff[j];
        diff[j] = t;
    }

    private void qsort(int[] a, int low, int high){
        if(low<high){
            int p = partition(a, low, high);
            qsort(a, low, p-1);
            qsort(a, p+1, high);
        }
    }

    private int partition(int[] a, int low, int high){
        int t = a[low];
        while(low<high){
            while(low<high&&a[high]>=t){
                high--;
            }
            a[low]=a[high];
            while(low<high&&a[low]<=t){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=t;
        return low;
    }

    public static void main(String[] args) {
        // write your code here
        MaxProfitAssignment826 a = new MaxProfitAssignment826();
        System.out.println(a.maxProfitAssignment(new int[]{2,4,6,8,10},new int[]{10,20,30,40,50},new int[]{4,5,6,7}));
        System.out.println(a.maxProfitAssignment(new int[]{85,47,57},new int[]{24,66,99},new int[]{40,25,25}));
        System.out.println(a.maxProfitAssignment(new int[]{13,37,58},new int[]{4,90,96},new int[]{34,73,45}));
        System.out.println(a.maxProfitAssignment(new int[]{68,35,52,47,86},new int[]{67,17,1,81,3},new int[]{92,10,85,84,82}));
    }
}
