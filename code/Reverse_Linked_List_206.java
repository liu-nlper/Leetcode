/**
 * Created by ljx on 17-7-19.
 *
 * Reverse a singly linked list.
 */
public class Reverse_Linked_List_206 {

    public static void main(String[] args) {
        new Reverse_Linked_List_206().demo();
    }

    private void demo() {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;

        ListNode head = reverseList(node_1);
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
