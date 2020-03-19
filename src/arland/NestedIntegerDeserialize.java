package arland;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiangchaolei
 */
public class NestedIntegerDeserialize {



      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public class NestedInteger {
          // Constructor initializes an empty nested list.

          Integer value;
          List<NestedInteger> list = new ArrayList<>();
          public NestedInteger(){

          }

          // Constructor initializes a single integer.
          public NestedInteger(int value){
              this.value = value;
          }

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger(){
              return value==null;
          }

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger(){
              return value;
          }

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value){
              this.value = value;
          }

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni){
              this.list.add(ni);
          }

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList(){
              return list;
         }
     }

    public NestedInteger deserialize(String s) {
        NestedInteger ret = new NestedInteger();
        int n = s.length();
        if(s.startsWith("[")&&s.endsWith("]")){
            s = s.substring(1, n-1);
            if(s.length()==0){
                return ret;
            }
            ret.add(deserializeInner(s));
        }
        else{
            ret.setInteger(Integer.valueOf(s));
        }
        return ret;
    }

    public NestedInteger deserializeInner(String s) {
        NestedInteger ret = new NestedInteger();
        int n = s.length();
        if(0==n){
            return ret;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c=='['){
                int j = i+1;
                int count = 1;
                while(j<n&&(count!=0||s.charAt(j)!=']')){
                    if(s.charAt(j)=='['){
                        count++;
                    }
                    if(s.charAt(j)==']'){
                        count--;
                    }
                    j++;
                }
                if(s.substring(i+1, j-1).length()==0){
                    return ret;
                }
                ret.add(deserializeInner(s.substring(i+1, j-1)));
                i = j+1;
            }
            else if(c==','){
            }
            else{
                int j = i+1;
                while(j<n&&s.charAt(j)!=','){
                    j++;
                }
                ret.setInteger(Integer.valueOf(s.substring(i, j+1>=n?n:j)));
                i = j;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        // write your code here

                NestedIntegerDeserialize a = new NestedIntegerDeserialize();

//        String s1 = "324";
//        NestedInteger ans1 = a.deserialize(s1);
        String s2 = "[123,[456,[789]]]";
        NestedInteger ans2 = a.deserialize(s2);
//
        String s3 = "[-1]";

//        NestedInteger ans3 = a.deserialize(s3);

//        String s4 = "[[]]";
//
//        NestedInteger ans4 = a.deserialize(s4);

        return;
    }
}
