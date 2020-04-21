package arland;

import java.util.Arrays;

/**
 * @author xiangchaolei
 */
public class KMP {

    public int find(char[] s, char[] t){
        int n = t.length;
        int[] next = new int[n];
        next(t, next);
        int i = 0, j = -1;
        while(i<s.length&&j<t.length){
            if(j==-1||s[i]==t[j]){
                j++;
                i++;
            }
            else{
                j = next[j];
            }
        }
        if(j==t.length){
            return i-j;
        }
        else {
            return -1;
        }
    }

    private void next(char[] t, int[] next){
        int n = next.length;
        int j = -1;
        int i = 0;
        next[0]=-1;
        while(i<n-1){
            if(j==-1||t[i]==t[j]){
                i++;
                j++;
                if(t[i]!=t[j]){
                    next[i] = j;
                }
                else{
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
