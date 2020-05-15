package arland;

/**
 * @author xiangchaolei
 */
public class LongestStrChain1048 {

    public int longestStrChain(String[] words) {
        int n = words.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        qsort(words, 0, n-1);
        int[] d = new int[n];
        d[0] = 1;
        int r_max = 0;
        for (int i = 1; i < words.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if(isFollower(words[j], words[i])){
//                    System.out.println(words[j]+" is prev of "+words[i]);
                    max = Math.max(max, d[j]+1);
                }
                else{
//                    System.out.println(words[j]+" is not prev of "+words[i]);
                }
            }
            d[i] = max;

            r_max = Math.max(r_max, d[i]);
        }
        return r_max;
    }

    /**
     * s是t的前缀
     * @param s
     * @param t
     * @return
     */
    private boolean isFollower(String s, String t){
        int m = s.length();
        int n = t.length();

        if(m==n||Math.abs(m-n)>1){
            return false;
        }

        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(i>j){
                    continue;
                }
                if(s.charAt(i-1)==t.charAt(j-1)&&dp[i-1][j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(dp[i-1][j]){
                    dp[i][j]=dp[i][j-1];
                }
            }
        }

//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        return dp[m][n];
    }

    private void qsort(String[] a, int low, int high){
        if(low<high){
            int p = partition(a,low,high);
            qsort(a, low, p-1);
            qsort(a, p+1, high);
        }
    }

    private int partition(String[] a, int low, int high){
        String t = a[low];
        while(low<high){
            while(low<high&&a[high].length()>=t.length()){
                high--;
            }
            a[low]=a[high];

            while(low<high&&a[low].length()<=t.length()){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=t;
        return low;
    }

    public static void main(String[] args) {
        // write your code here
        LongestStrChain1048 a = new LongestStrChain1048();
        System.out.println(a.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
        System.out.println(a.longestStrChain(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
        System.out.println(a.longestStrChain(new String[]{"wnyxmflkf","xefx","usqhb","ttmdvv","hagmmn","tmvv","pttmdvv","nmzlhlpr","ymfk","uhpaglmmnn","zckgh","hgmmn","isqxrk","isqrk","nmzlhpr","uysyqhxb","haglmmn","xfx","mm","wymfkf","tmdvv","uhaglmmn","mf","uhaglmmnn","mfk","wnymfkf","powttkmdvv","kwnyxmflkf","xx","rnqbhxsj","uysqhb","pttkmdvv","hmmn","iq","m","ymfkf","zckgdh","zckh","hmm","xuefx","mv","iqrk","tmv","iqk","wnyxmfkf","uysyqhb","v","m","pwttkmdvv","rnqbhsj"}));
        System.out.println(a.longestStrChain(new String[]{"bqtmbnugq","bjqtmbnuwsgq","m","btmnugq","czlhk","ihkgszexnh","wiszechhcxldcrow","kgszn","lhk","zlzfgmjurcntwvn","jjvodlrsmdmie","tm","ihqkgpszexnh","wnwpxg","zmun","hkgszenh","zmucnwn","kgzn","yjmk","wiszechcxldcrow","fnnh","yjm","jjvodlrmdmie","bqtmnugq","hkgszen","wehcxdrow","nhed","zmucn","wisehcxdrow","fnnlh","wehcxdro","zlzgmjurcntwvn","wnwg","jjvodlmde","wisechcxldcrow","wiehcxdrow","nhxyeedlcqxw","wehcxr","zzgmjurcnwvn","btmgq","nwdhslknbwpxg","ihqkgszexnh","jjvodlrsmdmhie","jjvodlmd","wdhslknbwpxg","nhedxw","wisehcxldcrow","btmugq","mfnnlfh","bqtmbnuwgq","nhedcxw","bqtmbnuwsgq","nhe","zzgmjurcntwvn","jjvodlrmdie","whslknwpxg","wdhslknwpxg","wsnwpxg","jjvodlm","hkgszexnh","zzgmjucnwvn","nhxyeedlcxw","nhxedcxw","zzmucnwn","hkgszn","zmucnw","whsnwpxg","czlmhk","whsknwpxg","wehcxro","wnwpg","nhxeedcxw","nwdhslknbjwpxg","nhedw","tmg","zlhk","zlzfgmjurcntwvnr","jjvodlmdie","zzmjucnwvn","mfnnlh","zzmjucnwn","wisehcxldrow","tmgq","nhxyeedcxw"}));
    }
}
