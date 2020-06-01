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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
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
        ListNode n = a.removeNthFromEnd(n1,5);
        a.print(n);

    }
}
