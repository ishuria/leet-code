package arland;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * @author xiangchaolei
 */
public class FindLHS594 {



    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(m.get(nums[i])==null){
                m.put(nums[i], 1);
            }
            else{
                m.put(nums[i], m.get(nums[i])+1);
            }
        }

        if(m.size()==0){
            return 0;
        }
        int max = 0;
        int prevKey = m.firstKey();


        Iterator<Integer> it = m.keySet().iterator();
        it.next();

        while(it.hasNext()){
            int thisKey = it.next();

            if(thisKey-prevKey!=1){
                prevKey = thisKey;
                continue;
            }

            int prevVal = m.get(prevKey);
            int thisVal = m.get(thisKey);

            max = Math.max(max, prevVal+thisVal);

            prevKey = thisKey;
        }

        return max;
    }


    public static void main(String[] args) {
        // write your code here

        //[1,3,2,2,5,2,3,7]
        //5
        FindLHS594 a = new FindLHS594();
        System.out.println(a.findLHS(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(a.findLHS(new int[]{1,1,1,1}));
        //[-1,0,-1,0,-1,0,-1]
        System.out.println(a.findLHS(new int[]{-1,0,-1,0,-1,0,-1}));
    }
}
