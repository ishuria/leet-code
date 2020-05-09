package arland;

/**
 * @author xiangchaolei
 */
public class KMP {

    public int find(char[] s, char[] t){
        int i = 0;
        int j = -1;
        int[] next = new int[t.length];
        next(t, next);
        while(i<s.length&&j<t.length){
            if(j==-1||t[j]==s[i]){
                i++;
                j++;
            }
            else{
                j = next[j];
            }
        }
        if(j==t.length){
            return i-j;
        }
        else{
            return -1;
        }
    }

    private void next(char[] t, int[] next){
        int i = 0;
        int j = -1;
        next[0]=-1;
        while(i<next.length-1){
            if(j==-1||t[i]==t[j]){
                i++;
                j++;
                if(t[i]!=t[j]){
                    next[i] = j;
                }
                else{
                    next[i]=next[j];
                }
            }
            else {
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
