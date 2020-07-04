package arland;

import java.util.TreeMap;

/**
 * @author xiangchaolei
 */
public class IsNStraightHand {

    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> count = new TreeMap();
        for (int card: hand) {
            if (!count.containsKey(card))
                count.put(card, 1);
            else
                count.replace(card, count.get(card) + 1);
        }

        while (count.size() > 0) {
            int first = count.firstKey();
            for (int card = first; card < first + W; ++card) {
                if (!count.containsKey(card)) return false;
                int c = count.get(card);
                if (c == 1) count.remove(card);
                else count.replace(card, c - 1);
            }
        }
        return true;
    }



//    public boolean isNStraightHand(int[] hand, int W) {
//        int n = hand.length;
//        if(n%W!=0){
//            return false;
//        }
//        int k = n / W;
//        int[][] groups = new int[k][W];
//        int[] groupIndex = new int[k];
//        Arrays.sort(hand);
//        return isNStraightHand(hand, 0, groups, groupIndex, W);
//    }
//
//    private boolean isNStraightHand(int[] hand, int index, int[][] groups, int[] groupIndex, int W){
//        if(index>=hand.length){
//            return true;
//        }
//        int v = hand[index];
//        int n = groups.length;
//        for (int i = 0; i < n; i++) {
//            if(groupIndex[i]==0){
//                groups[i][groupIndex[i]] = v;
//                groupIndex[i]++;
//                if(isNStraightHand(hand, index+1, groups, groupIndex, W)){
//                    return true;
//                }
//                else{
//                    groupIndex[i]--;
//                    groups[i][groupIndex[i]] = 0;
//                }
//            }
//            else if(groupIndex[i]<W&&groups[i][groupIndex[i]-1]==(v-1)){
//                groups[i][groupIndex[i]] = v;
//                groupIndex[i]++;
//                //递归尝试下一个数字
//                if(isNStraightHand(hand, index+1, groups, groupIndex, W)){
//                    return true;
//                }
//                else{
//                    groupIndex[i]--;
//                    groups[i][groupIndex[i]] = 0;
//                }
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        // write your code here

        IsNStraightHand a = new IsNStraightHand();

        int[] a1 = {1,2,3,6,2,3,4,7,8};
        int b1 = 3;
        System.out.println(a.isNStraightHand(a1,b1));


        int[] a2 = {1,2,3,4,5};
        int b2 = 4;
        System.out.println(a.isNStraightHand(a2,b2));

        int[] a3 = {1,2,3,4,5,6};
        int b3 = 2;
        System.out.println(a.isNStraightHand(a3,b3));

        int[] a4 = {1,1,2,2,3,3};
        int b4 = 2;
        System.out.println(a.isNStraightHand(a4,b4));

        int[] a5 = {595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513,50283010,159119807,511315692,270647046,851420098,371036797,727204835,159618343,511404053,362041836,291098889,837814735,801217825,458646709,960909479,836037288,164637420,202500334,132289961,517556575,183265101,732053054,190062728,192602923,551817738,880105762,67914564,336769190,208588970,748586819,57544790,922070787,299351164,42155594,120233240,184503545,976640197,453293964,150570427,82070647,96753504,281100317,560248661,57418300,691978908,549298412,948924542,930276117,464831683,28176616,294693989,411732472,284815364,739475432,93001772,102349400,143894921,804459551,516101973,231508423,570486100,759554871,585378770,183574568,659044634,255283110,862751001,464295274,321757125,956710543,17438292,669631155,515964881,525552571,852811489,115244590,352774049,15908499,407411365,345070789,520848723,637667085,894912460,535256393,838314792,982883096,669223549};
        int b5 = 2;
        System.out.println(a.isNStraightHand(a5,b5));
    }
}
