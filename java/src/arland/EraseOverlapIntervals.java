//package arland;
//
//import java.util.*;
//
///**
// * @author xiangchaolei
// */
//public class EraseOverlapIntervals {
//
//    Map<String, Integer> m = new HashMap<>();
//
//    public int eraseOverlapIntervals(int[][] intervals) {
//        int n = intervals.length;
//
//
//        for (int i = 0; i < n; i++) {
//
//            List<Integer> left = new ArrayList<>();
//            for (int j = 0; j < n; j++) {
//                if(i==j){
//                    continue;
//                }
//                if(!isOverlap(intervals[i], intervals[j])){
//                    left.add(j);
//                }
//            }
//
//            String key = Arrays.toString(left.toArray());
//
//            int innerRemoveCount = 0;
//            if(m.containsKey(key)){
//                innerRemoveCount = m.get(key);
//            }
//            else{
//                innerRemoveCount = eraseOverlapIntervals()
//            }
//
//            int removeCount = n - 1 - left.size();
//        }
//    }
//
//    public int eraseOverlapIntervalsInner(int[][] intervals, List<Integer> left) {
//        if(left.size()==1){
//            return 0;
//        }
//        String key = Arrays.toString(left.toArray());
//        int innerRemoveCount = 0;
//        if(m.containsKey(key)){
//            innerRemoveCount = m.get(key);
//        }
//        else{
//            innerRemoveCount = eraseOverlapIntervals()
//        }
//    }
//
//    private boolean isOverlap(int[] a, int[] b){
//        return !(a[0]>=b[1]||b[0]>=a[1]);
//    }
//
//    public static void main(String[] args) {
//        // write your code here
//
//        int[][] a1 = { {1,2}, {2,3}, {3,4}, {1,3} };
//        int[][] a2 = { {1,2}, {1,2}, {1,2} };
//        int[][] a3 = { {1,2}, {2,3} };
//
//
//        EraseOverlapIntervals a = new EraseOverlapIntervals();
//        System.out.println(a.eraseOverlapIntervals(a1));
//        System.out.println(a.eraseOverlapIntervals(a2));
//        System.out.println(a.eraseOverlapIntervals(a3));
//    }
//}
