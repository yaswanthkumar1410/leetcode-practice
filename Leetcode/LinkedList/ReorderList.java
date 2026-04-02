
public class ReorderList {

    public static void main(String[] args) {
        printList(reorderList(buildList(new int[] { 1, 2, 3, 4 }))); // 1 4 2 3
        printList(reorderList(buildList(new int[] { 1, 2, 3, 4, 5 }))); // 1 5 2 4 3
        printList(reorderList(buildList(new int[] { 1 }))); // 1
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // ============================================
    // LC 143 — Reorder List
    // ============================================
    // Given a singly linked list:
    // L0 → L1 → L2 → ... → Ln-1 → Ln
    // Reorder it to:
    // L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...
    //
    // Do it in-place.
    //
    // Example: [1,2,3,4] → [1,4,2,3]
    // Example: [1,2,3,4,5] → [1,5,2,4,3]
    // ============================================
    static ListNode reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

        return head;
    }

    static ListNode buildList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        System.out.println(sb.toString().trim());
    }
}
