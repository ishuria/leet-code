package arland;

/**
 * @author xiangchaolei
 */
public class ExpressiveWords809 {

    public int expressiveWords(String S, String[] words) {
        int c = 0;
        for (String word : words) {
            int i=0,j=0;
            boolean match = true;
            while(i<S.length()){
                if(S.charAt(i)!=word.charAt(j)){
                    match = false;
                    break;
                }
                int next_i = i+1, next_j = j+1;

                while(next_i<S.length()&&S.charAt(next_i)==S.charAt(next_i-1)){
                    next_i++;
                }

                while(next_j<word.length()&&word.charAt(next_j)==word.charAt(next_j-1)){
                    next_j++;
                }

                int l_i = next_i - i;
                int l_j = next_j - j;

                boolean subMatch = false;

                while(l_j>1){
                    if( ( (l_i) - (l_j)  ) / l_j >= 3  ){
                        subMatch = true;
                        break;
                    }
                    else{
                        l_i--;
                        l_j--;
                    }
                }

                if(next_i - i>1&&!subMatch){
                    match = false;
                    break;
                }

                i = next_i;
                j = next_j;
            }
            if(match){
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        // write your code here
        ExpressiveWords809 a = new ExpressiveWords809();
        System.out.println(a.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(a.expressiveWords("zzzzzyyyyy", new String[]{"zzyy","zy","zyy"}));
    }
}
