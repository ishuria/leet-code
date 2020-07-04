package arland;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangchaolei
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {

        List<Integer> d = new ArrayList<>(triangle.size());
        d.add(0, triangle.get(0).get(0));

        List<Integer> dprev = new ArrayList<>(triangle.size());
        dprev.add(0, triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < i+1; j++) {
                if(j==0){
                    d.add(j, dprev.get(j)+triangle.get(i).get(j));
                }
                else if(j == i){
                    d.add(j, triangle.get(i).get(j) + dprev.get(j-1));
                }
                else{
                    d.add(j,
                            Math.min(triangle.get(i).get(j) + dprev.get(j-1),
                                    triangle.get(i).get(j) + dprev.get(j)));
                }
            }
            dprev = d;
            d = new ArrayList<>(dprev);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            if(d.get(i)<min){
                min = d.get(i);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        // write your code here

        List<List<Integer>> a = new ArrayList<>();

        List<Integer> b1 = new ArrayList<>();
        b1.add(2);
        List<Integer> b2 = new ArrayList<>();
        b2.add(3);
        b2.add(4);

        List<Integer> b3 = new ArrayList<>();
        b3.add(6);
        b3.add(5);
        b3.add(7);
        List<Integer> b4 = new ArrayList<>();
        b4.add(4);
        b4.add(1);
        b4.add(8);
        b4.add(3);


        a.add(b1);
        a.add(b2);
        a.add(b3);
        a.add(b4);

        MinimumTotal c = new MinimumTotal();
        System.out.println(c.minimumTotal(a));
    }
}
