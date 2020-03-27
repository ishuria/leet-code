package arland;

/**
 * @author xiangchaolei
 */
public class FindLongestChain {

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];

        int[][] pairsplus = new int[n+1][2];

        System.arraycopy(pairs, 0, pairsplus, 1, n);

//        qsort(pairs, 0, n-1);
        heapsort(pairsplus);

        System.arraycopy(pairsplus, 1, pairs, 0, n);

        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <i ; j++) {
                if(pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                else{
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public void heapsort(int[][] a){
        for (int i = (a.length-1)/2; i >=1 ; i--) {
            heapAdjust(a, i, a.length-1);
        }
        for (int i = a.length-1; i >=1 ; i--) {
            swap(a[i], a[1]);
            heapAdjust(a, 1, i-1);
        }
    }

    public void heapAdjust(int[][] a, int s, int m){
        int[] t = new int[2];
        t[0] = a[s][0];
        t[1] = a[s][1];
        for (int i = s*2; i<=m ; i*=2) {
            if(i<m&&a[i][0]<a[i+1][0]){
                i++;
            }
            if(a[i][0]<t[0]||(a[i][0]==t[0]&&a[i][1]<t[1])){
                break;
            }
            a[s][0]=a[i][0];
            a[s][1]=a[i][1];
            s = i;
        }
        a[s][0] = t[0];
        a[s][1] = t[1];
    }

    public void swap(int[] a, int[] b){
        int[] t = new int[2];
        t[0] = a[0];
        t[1] = a[1];
        a[0]=b[0];
        a[1]=b[1];
        b[0]=t[0];
        b[1]=t[1];
    }

    public void qsort(int[][] a, int low, int high){
        if(low<high){
            int p = partition(a, low, high);
            qsort(a, low, p-1);
            qsort(a, p+1, high);
        }
    }

    public int partition(int[][] a, int low, int high){
        int[] t = new int[2];
        t[0] = a[low][0];
        t[1] = a[low][1];
        while(low<high){
            while(low<high&&a[high][0]>=t[0]){
                high--;
            }
            a[low][0] = a[high][0];
            a[low][1] = a[high][1];
            while(low<high&&a[low][0]<=t[0]){
                low++;
            }
            a[high][0] = a[low][0];
            a[high][1] = a[low][1];
        }
        a[low][0] = t[0];
        a[low][1] = t[1];
        return low;
    }

    public static void main(String[] args) {
        // write your code here
        FindLongestChain a = new FindLongestChain();
        int[][] a1 = {{1,2}, {2,3}, {3,4}, {4,5}, {5,6}};
        int[][] a2 = {{3,4},{2,3},{1,2}};
        int[][] a3 = {{9,10},{-4,9},{-5,6},{-5,9},{8,9}};

        int[][] a4 = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
        // {-9,8}, {-6,-2}, {-6,9}, {-5,3}, {-1,4}, {0,3}, {1,6}, {8,10}
//        System.out.println(a.findLongestChain(a1));
//        System.out.println(a.findLongestChain(a2));
//        System.out.println(a.findLongestChain(a3));
        System.out.println(a.findLongestChain(a4));//3
    }
}
