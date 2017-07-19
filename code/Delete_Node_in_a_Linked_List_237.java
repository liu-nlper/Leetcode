/**
 * Created by ljx on 17-7-19.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

   Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Delete_Node_in_a_Linked_List_237 {

    public static void main(String[] args) {
        new Delete_Node_in_a_Linked_List_237().demo();
    }


    private void demo() {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;

        deleteNode(node_3);

        ListNode node = node_1;
        while(node != null) {
            System.out.print(node.val + "　");
            node = node.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
