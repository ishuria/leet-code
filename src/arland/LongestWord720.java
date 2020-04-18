package arland;

/**
 * @author xiangchaolei
 */
public class LongestWord720 {

    class TrieNode{
        char c;
        boolean end;
        TrieNode[] children;
        TrieNode(char c){
            this.c = c;
            end = false;
            children = new TrieNode[26];
        }
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode('0');

        for (int i = 0; i < words.length; i++) {
            TrieNode p = root;

            int n = words[i].length();

            for (int j = 0; j < n; j++) {
                if(p.children[words[i].charAt(j)-'a']==null){
                    p.children[words[i].charAt(j)-'a'] = new TrieNode(words[i].charAt(j));
                }
                p = p.children[words[i].charAt(j)-'a'];
                if(j==n-1){
                    p.end= true;
                }
            }
        }
        return dfs(root, new char[35], 0, "").substring(1).trim();
    }

    private String dfs(TrieNode p, char[] prev, int pos, String currentMax){
        if(isLeaf(p)){
            prev[pos] = p.c;
            String m = new String(prev);
            if(m.trim().length()>currentMax.trim().length()){
                return m;
            }
            else{
                return currentMax;
            }
        }
        for (int i = 0; i < p.children.length; i++) {
            if(p.children[i]!=null){
                TrieNode n = p.children[i];
                if(!n.end){
                    prev[pos] = p.c;
                    String m = new String(prev);
                    if(m.trim().length()>currentMax.trim().length()){
                        currentMax = m;
                    }
                    continue;
                }
                prev[pos] = p.c;
                String m = dfs(n, prev, pos+1, currentMax);
                if(m.trim().length()>currentMax.trim().length()){
                    currentMax = m;
                }
            }
        }
        return currentMax;
    }

    private boolean isLeaf(TrieNode p){
        if(p.children==null){
            return true;
        }
        else {
            boolean isLeaf = true;
            for (int i = 0; i < p.children.length; i++) {
                if(p.children[i]!=null){
                    isLeaf = false;
                }
            }
            return isLeaf;
        }
    }

    public static void main(String[] args) {
        // write your code here
        LongestWord720 a = new LongestWord720();
        System.out.println(a.longestWord(new String[]{"w","wo","wor","worl", "world"}));
        System.out.println(a.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(a.longestWord(new String[]{"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"}));
        System.out.println(a.longestWord(new String[]{"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"}));
    }
}
