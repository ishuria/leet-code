package arland;

/**
 * @author xiangchaolei
 */
public class InsertionSortList {


    public static class ListNode {
      int val;
      ListNode next;
    ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if(null==head){
            return head;
        }
        ListNode t = head;
        while(t.next!=null){
            ListNode next = t.next;
            if(next.val<t.val){
                //delete next
                t.next = next.next;
                //search from head
                ListNode s = head;
                while(s.val<=next.val){
                    s=s.next;
                }
                //insert next
                insertBefore(s, next);
            }
            else{
                t = t.next;
            }
        }
        print(head);
        return head;
    }

    private void insertBefore(ListNode node, ListNode toAdd){
        toAdd.next = node.next;
        node.next = toAdd;

        int t = node.val;
        node.val = toAdd.val;
        toAdd.val = t;
    }

    private void print(ListNode head){
        while(head!=null){
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // write your code here

        InsertionSortList a = new InsertionSortList();

        //4->2->1->3
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        a.insertionSortList(n1);

        //-1->5->3->4->0
        ListNode n21 = new ListNode(-1);
        ListNode n22 = new ListNode(5);
        ListNode n23 = new ListNode(3);
        ListNode n24 = new ListNode(4);
        ListNode n25 = new ListNode(0);
        n21.next=n22;
        n22.next=n23;
        n23.next=n24;
        n24.next=n25;
        a.insertionSortList(n21);
    }
}
