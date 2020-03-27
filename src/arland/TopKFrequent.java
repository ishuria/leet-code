package arland;

import java.util.*;

/**
 * @author xiangchaolei
 */
public class TopKFrequent {


    private class Word{
        int c;
        String w;
        Word(int c, String w){
            this.c = c;
            this.w = w;
        }
    }

    Map<String, Word> s = new HashMap<>();

    public List<String> topKFrequent(String[] words, int k) {
        for (int i = 0; i < words.length; i++) {
            if(s.containsKey(words[i])){
                s.get(words[i]).c++;
            }
            else{
                s.put(words[i], new Word(1, words[i]));
            }
        }

        Word[] words1 = s.values().toArray(new Word[0]);


        Word[] words2 = new Word[words1.length+1];

        System.arraycopy(words1, 0, words2, 1, words1.length);

//        qsort(words1, 0, words1.length-1);

//        List<String> r = new ArrayList<>(Math.min(k, words1.length));
//        for (int i = words1.length-1; i >= words1.length-k&&i>=0; i--) {
//            r.add(words1[i].w);
//        }

        hs(words2);

        List<String> r = new ArrayList<>(Math.min(k, words2.length));
        for (int i = words2.length-1; i >= words2.length-k&&i>=0; i--) {
            r.add(words2[i].w);
        }
        return r;
    }

    private void qsort(Word[] e, int low, int high){
        if(low<high){
            int p = partition(e, low, high);
            qsort(e, low, p-1);
            qsort(e, p+1, high);
        }
    }

    private int partition(Word[] e, int low, int high){
        Word t = e[low];
        while(low<high){
            while(low<high&&e[high].c>=t.c)high--;
            e[low]=e[high];
            while(low<high&&e[low].c<=t.c)low++;
            e[high]=e[low];
        }
        e[low]=t;
        return low;
    }

    private void hs(Word[] e){
        for (int i = (e.length-1)/2; i >=1 ; i--) {
            ha(e, i, e.length-1);
        }
        for (int i = e.length-1; i >=1; i--) {
            swap(e, 1, i);
            ha(e, 1, i-1);
        }
    }

    private void ha(Word[] e, int s, int m){
        Word t = e[s];
        for (int i = s*2; i <=m ; i*=2) {
            if(i<m&&e[i].c<e[i+1].c){
                i++;
            }
            if(e[i].c<t.c){
                break;
            }
            else if(e[i].c==t.c){
                if(e[i].w.compareTo(t.w)>0){
                    break;
                }
            }
            e[s] = e[i];
            s=i;
        }
        e[s] = t;
    }

    private void swap(Word[] e, int a, int b){
        Word t = e[a];
        e[a] = e[b];
        e[b] = t;
    }

    public static void main(String[] args) {
        // write your code here

        TopKFrequent a = new TopKFrequent();
        System.out.println(Arrays.toString(a.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2).toArray()));
        a = new TopKFrequent();
        System.out.println(Arrays.toString(a.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4).toArray()));

        a = new TopKFrequent();
        System.out.println(Arrays.toString(a.topKFrequent(new String[]{"a","aa","aaa"},1).toArray()));
    }
}
