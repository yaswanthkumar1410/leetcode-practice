
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode t1 = buildList(new int[]{1,2,3,4,5});
        printList(reverseList(t1)); // 5 4 3 2 1

        ListNode t2 = buildList(new int[]{1,2});
        printList(reverseList(t2)); // 2 1

        printList(reverseList(null)); // (empty)
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // ============================================
    // LC 206 — Reverse Linked List
    // ============================================
    // Given the head of a singly linked list, reverse
    // the list, and return the reversed list.
    // ============================================
    static ListNode reverseList(ListNode head) {
        // your code here
        ListNode result = null;
        while(head != null) {
            ListNode temp1 = head.next;
            head.next = result;
            result = head;
            head = temp1;
        }
        return result;
    }

    static ListNode buildList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) { curr.next = new ListNode(v); curr = curr.next; }
        return dummy.next;
    }

    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) { sb.append(head.val).append(" "); head = head.next; }
        System.out.println(sb.toString().trim());
    }
}
