package arland;

import java.util.List;

/**
 * @author xiangchaolei
 */
public class RemoveNthFromEnd19 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode t =head;
//        t.next=head;

        for (int i = 0; i < n-1; i++) {
            if(t==null){
                return null;
            }
            t = t.next;
        }

        ListNode pre=new ListNode(0);
        pre.next = head;
//        pre=head;

        ListNode prepre = null;
        if(t==null){
            return null;
        }

        while(t.next!=null){
            t=t.next;
//            prepre = pre;
            pre=pre.next;
        }

        ListNode p = pre.next;

        pre.next = pre.next.next;
        p.next = null;
        return p;
    }

    private void print(ListNode head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // write your code here

        //1->2->3->4->5, 和 n = 2.

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;


        RemoveNthFromEnd19 a = new RemoveNthFromEnd19();
        ListNode n = a.removeNthFromEnd(n1,2);
        System.out.println(n==null?"null":n.val);
        a.print(n1);

    }
}
