package arland;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiangchaolei
 */
public class MincostTickets {

    public int mincostTickets(int[] days, int[] costs) {

        int[] d = new int[400];

        int n = days.length;

        Set<Integer> daySet = new HashSet<>();

        for (int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
        }

        for (int i = 365; i >= 1; i--) {
            if(daySet.contains(i)){
                d[i] = Math.min(Math.min(d[i+1]+costs[0], d[i+7]+costs[1]), d[i+30]+costs[2]);
            }
            else{
                d[i] = d[i+1];
            }
        }
        return d[1];
    }

    public static void main(String[] args) {
        // write your code here


        MincostTickets a = new MincostTickets();
        System.out.println(a.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
        System.out.println(a.mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }
}
