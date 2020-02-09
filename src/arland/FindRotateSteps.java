package arland;

/**
 * @author xiangchaolei
 */
public class FindRotateSteps {

    public int findRotateSteps(String ring, String key) {

        int n = ring.length();
        int m = key.length();


        //转到ring[i]的最小距离
        int[] dpPrev = new int[n];
        for (int j = 0; j < n; j++) {
            dpPrev[j] = 10000;
        }
        char c1 = key.charAt(0);
        for (int i = 0; i < 1; i++) {
            for (int k = 0; k < n; k++) {
                if(ring.charAt(k)==c1){
                    int step = Math.min(Math.abs(k-i),n-Math.abs(k-i))+1;
                    dpPrev[k] = step;
                }
            }

        }

//        for (int j = 0; j < n; j++) {
//            System.out.print(dpPrev[j]+" ");
//        }
//        System.out.println();

        for (int i = 1; i < m; i++) {
            char c = key.charAt(i);
            int[] dp = new int[n];
            for (int j = 0; j < n; j++) {
                dp[j] = 10000;
            }

            for (int j = 0; j < n; j++) {
                if(ring.charAt(j)==c){
                    int min = 10000;
                    for (int k = 0; k < n; k++) {
                        int step = dpPrev[k]+Math.min(Math.abs(k-j),n-Math.abs(k-j))+1;
                        min = Math.min(step,min);
                    }
                    dp[j] = min;
                }
            }
            dpPrev = dp;


//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[j]+" ");
//            }
//            System.out.println();
        }

        int min = 10000;
        for (int k = 0; k < n; k++) {
            if(min>=dpPrev[k]){
                min = dpPrev[k];
            }
        }

        return min;
    }


    public static void main(String[] args) {

        String ring1 = "godding", key1 = "gd";
        String ring2 = "godding", key2 = "godding";
        String ring3 = "pqwcx", key3 = "cpqwx";

        String ring4 = "ababcab", key4 = "acbaacba";

        // write your code here
        FindRotateSteps a = new FindRotateSteps();
        System.out.println(a.findRotateSteps(ring1,key1));//4
        System.out.println(a.findRotateSteps(ring2,key2));//13
        System.out.println(a.findRotateSteps(ring3,key3));//13
        System.out.println(a.findRotateSteps(ring4,key4));//17
    }
}
