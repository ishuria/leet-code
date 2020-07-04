package arland;

/**
 * @author xiangchaolei
 */
public class NumDecodings {

    public int numDecodings(String s) {

        if(s.startsWith("0")){
            return 0;
        }

        int m = s.length();
        if(0 == m){
            return 0;
        }
        if(1 == m){
            return 1;
        }
        int[] d = new int[s.length()];
        d[0] = 1;

        int p = Integer.valueOf(s.substring(0,2));
        if(p<=26&&(p!=10&&p!=20)){
            d[1] = 2;
        }
        else{
            d[1] = 1;
        }
        for (int i = 2; i < m; i++) {
            p = Integer.valueOf(s.substring(i-2,i));
            int q = Integer.valueOf(s.substring(i-1,i));
            if(p<=26&&(p!=10&&p!=20)){
                d[i] = d[i-1]+ d[i-2] ;
            }
            else{
                d[i] = d[i-1];
            }
        }
        return d[m-1];
    }

    public static void main(String[] args) {
        // write your code here
        NumDecodings a = new NumDecodings();
        System.out.println(a.numDecodings("12"));
        System.out.println(a.numDecodings("226"));
        System.out.println(a.numDecodings("2312"));
        System.out.println(a.numDecodings("45352"));
        System.out.println(a.numDecodings(""));
        System.out.println(a.numDecodings("0"));
        System.out.println(a.numDecodings("01"));
        System.out.println(a.numDecodings("10"));
        System.out.println(a.numDecodings("100"));
    }
}
