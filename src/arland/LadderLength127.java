package arland;

import java.util.*;

/**
 * @author xiangchaolei
 */
public class LadderLength127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        wordList.add(beginWord);
        int n = wordList.size();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n&&i1!=i; i1++) {
                boolean neighbour = isNeighbour(wordList.get(i), wordList.get(i1));
                g[i][i1] = neighbour;
                g[i1][i] = neighbour;
            }
        }
        return bfs(g, wordList.indexOf(beginWord), wordList.indexOf(endWord));
    }

    public boolean isNeighbour(String a, String b){
        int n = a.length();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if(a.charAt(i)!=b.charAt(i)){
                c++;
                if(c>=2){
                    return false;
                }
            }
        }
        return true;
    }

    //digkstra
    public int bfs(boolean[][] g, int start, int end){
        int[] p = new int[g.length];
        boolean[] v = new boolean[g.length];
        for (int i = 0; i < p.length; i++) {
            if(i!=start){
                p[i]=Integer.MAX_VALUE;
            }
        }
        p[start]=1;
        v[start] = true;
        int unVisitNode = g.length ;
        int index = start;
        while (unVisitNode > 0 && !v[end] ){
            int min = Integer.MAX_VALUE;
            for (int i = 0;i<g.length;i++){
                if (min > p[i] && !v[i]){
                    index = i;
                    min = p[i];
                }
            }
            for (int i = 0;i<g.length;i++){
                if (g[index][i] && p[index] + 1 < p[i]){
                    p[i] = p[index] + 1;
                }
            }
            unVisitNode -- ;
            v[index] = true;
        }
        if(!v[end]){
            return 0;
        }
        else{
            return p[end];
        }
    }

    public static void main(String[] args) {
        // write your code here
        LadderLength127 a = new LadderLength127();
        List<String> a1 = new ArrayList<>(5);
        a1.add("hot");
        a1.add("dot");
        a1.add("dog");
        a1.add("lot");
        a1.add("log");
        a1.add("cog");
        System.out.println(a.ladderLength("hit", "cog", a1));

    }
}
