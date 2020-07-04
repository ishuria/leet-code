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
    //基于邻接矩阵
    public int bfs(boolean[][] g, int start, int end){
        int[] distance = new int[g.length];
        boolean[] visited = new boolean[g.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        visited[start]=true;
        distance[start]=1;
        int index = start;
        int count = g.length;
        while(count>=0&&!visited[end]){
            //寻找未访问的最小节点
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < distance.length; i++) {
                if(distance[i]<min&&!visited[i]){
                    index = i;
                    min = distance[i];
                }
            }
            for (int i = 0; i < distance.length; i++) {
                if(g[index][i]){
                    distance[i] = Math.min(distance[i], distance[index] + 1);
                }
            }
            count--;
            visited[index]=true;
        }
        if(!visited[end]){
            return 0;
        }
        else{
            return distance[end];
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
