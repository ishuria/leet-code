package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class KMP {

    public int find(char[] s, char[] t){
        int n = s.length;
        int m = t.length;
        int i = 0; int j = 0;
        int[] next = new int[t.length];
        next(t, next);
        while(j<m&&i<n){
            if(j==-1||s[i]==t[j]){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if(j==m){
            return i-m;
        }
        return -1;
    }

    private void next(char[] t, int[] next){
        int n = t.length;
        next[0]=-1;
        int j = -1, i = 0;
        while(i<n-1){
            if(j==-1||t[j]==t[i]){
                i++;
                j++;
//                next[i] = j;
                if (t[i] != t[j]) {
                    next[i] = j;
                }
                else {
                    next[i] = next[j];
                }
            }
            else{
                j = next[j];
            }
        }
    }


    public static void main(String[] args) {
        // write your code here
        KMP a = new KMP();
        char[] s = new char[]{'B','B','C','A','B','C','D','A','B','A','B','C','D','A','B','C','D','A','B','D','E'};
        char[] t = new char[]{'A','B','C','D','A','B','D'};
        System.out.println(a.find(s, t));
    }
}
