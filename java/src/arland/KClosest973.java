package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class KClosest973 {

    public int[][] kClosest(int[][] points, int K) {
//        abs(points);
        int[][] points2 = new int[points.length+1][];
        System.arraycopy(points,0,points2,1,points.length);
        hs(points2);
        return Arrays.copyOfRange(points2, points2.length-K, points2.length);
    }
    
    private void abs(int[][] points){
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            for (int i1 = 0; i1 < point.length; i1++) {
                point[i1] = Math.abs(point[i1]);
            }
        }
    }
    
    private void hs(int[][] a){
        for (int i = (a.length-1)/2; i >= 1; i--) {
            ha(a, i, a.length-1);
        }
        for (int i = a.length-1; i >=1 ; i--) {
            swap(a, i, 1);
            ha(a, 1, i-1);
        }
    }

    private void ha(int[][] a, int s, int m){
        int[] t = a[s];
        for (int i = s*2; i <=m ; i*=2) {
            if(i<m&&cmp(a[i],a[i+1])>0){
                //find min
                i++;
            }
            if(cmp(t,a[i])<=0){
                break;
            }
            a[s] = a[i];
            s=i;
        }
        a[s] = t;
    }

    private int cmp(int[] a, int[] b){
        return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]);
    }

    private void swap(int[][] a, int i, int j){
        int[] t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        // write your code here
        KClosest973 a = new KClosest973();

        int[][] a1 = {{1,3},{-2,2}};
        int K1 = 1;

        int[][] b1 = a.kClosest(a1, K1);

        for (int i = 0; i < b1.length; i++) {
            System.out.println(Arrays.toString(b1[i]));
        }



        int[][] a2 = {{3,3},{5,-1},{-2,4}};
        int K2 = 2;
        int[][] b2 = a.kClosest(a2, K2);

        for (int i = 0; i < b2.length; i++) {
            System.out.println(Arrays.toString(b2[i]));
        }



        int[][] a3 = {{2,2},{2,2},{2,2},{2,2},{2,2},{2,2},{1,1}};
        int K3 = 1;

        int[][] b3 = a.kClosest(a3, K3);

        for (int i = 0; i < b3.length; i++) {
            System.out.println(Arrays.toString(b3[i]));
        }

    }
}
