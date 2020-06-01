package arland;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author xiangchaolei
 */
public class LongestDiverseString1405 {


    public String longestDiverseString(int a, int b, int c) {
        TreeMap<Integer, String> m = new TreeMap<>();
        m.put(a, "a");
        m.put(b, "b");
        m.put(c, "c");

        StringBuilder s = new StringBuilder();

        while(!m.isEmpty()){
            Map.Entry<Integer, String> e = m.firstEntry();
            if(e.getKey()>2){
                s.append(e.getValue());
                s.append(e.getValue());
            }
        }

        return "";
    }


    public static void main(String[] args) {
        // write your code here
        LongestDiverseString1405 a = new LongestDiverseString1405();
        System.out.println(a.longestDiverseString(1,1,7));
        System.out.println(a.longestDiverseString(2,2,1));
        System.out.println(a.longestDiverseString(7,1,0));
    }
}
