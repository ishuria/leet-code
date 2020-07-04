package arland;

import java.util.*;

/**
 * @author xiangchaolei
 */
public class WordFilter745 {

    class TrieNode{
        int wt;
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    private void insert(String word, int wt){
        TrieNode p = preRoot;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(p.children[index]==null){
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
            if(i==n-1){
                p.isEnd=true;
                p.wt = wt;
            }
        }

        p = sufRoot;
        for (int i = n-1; i >= 0; i--) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(p.children[index]==null){
                p.children[index] = new TrieNode();
            }
            p = p.children[index];
            if(i==0){
                p.isEnd=true;
                p.wt = wt;
            }
        }
    }

    TrieNode preRoot = new TrieNode();
    TrieNode sufRoot = new TrieNode();

    public WordFilter745(String[] words) {

        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            m.put(words[i], i);
        }
        Iterator<String> it = m.keySet().iterator();
        while(it.hasNext()) {
            String word = it.next();
            int wt = m.get(word);
            insert(word, wt);
        }
    }

    private TrieNode findPre(String prefix){
        TrieNode p = preRoot;
        int pn = prefix.length();
        for (int i = 0; i < pn; i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(p.children[index]==null){
                return null;
            }
            p = p.children[index];
        }
        return p;
    }

    private TrieNode findSuf(String suffix){
        TrieNode p = sufRoot;
        int sn = suffix.length();
        for (int i = sn-1; i >=0; i--) {
            char c = suffix.charAt(i);
            int index = c - 'a';
            if(p.children[index]==null){
                return null;
            }
            p = p.children[index];
        }
        return p;
    }


    public int f(String prefix, String suffix) {
        TrieNode p = findPre(prefix);
        TrieNode s = findSuf(suffix);
        if(null==p||null==s){
            return -1;
        }

        List<Integer> pl = new LinkedList<>();
        List<Integer> sl = new LinkedList<>();
        dfs(p, pl);
        dfs(s, sl);

        int max = -1;
        for (int i = 0; i < pl.size(); i++) {
            for (int i1 = 0; i1 < sl.size(); i1++) {
                if(pl.get(i).equals(sl.get(i1))){
                    max = Math.max(max, pl.get(i));
                }
            }
        }
        return max;
    }
    
    private void dfs(TrieNode p, List<Integer> list){
        if(null==p){
            return;
        }
        list.add(p.wt);
        for (int i = 0; i < p.children.length; i++) {
            if(p.children[i]!=null){
                dfs(p.children[i], list);
            }
        }
    }


    public static void main(String[] args) {
        // write your code here
        WordFilter745 a = new WordFilter745(new String[]{"apple","apple"});
        System.out.println(a.f("apple", "e"));
        System.out.println(a.f("b", ""));
    }
}
