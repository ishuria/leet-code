package arland;

/**
 * @author xiangchaolei
 */
public class KSimilarity854 {

    public int kSimilarity(String A, String B) {
        int count = 0;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        int n = A.length();
        //如果有a[i]=b[j]且a[j]=b[i]的情况，直接互换
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(a[i]==b[j]&&a[j]==b[i]){
                    count++;
                    swap(a, i, j);
                }
            }
        }
        return 0;
    }

    public void swap(char[] a, int i, int j){
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
