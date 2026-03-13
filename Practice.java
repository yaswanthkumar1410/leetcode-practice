
public class Practice {

    public static void main(String[] args) {
        // Test 1: [1,2,4] + [1,3,4] → "1 -> 1 -> 2 -> 3 -> 4 -> 4"
        printList(mergeTwoLists(buildList(new int[]{1,2,4}), buildList(new int[]{1,3,4})));

        // Test 2: [] + [] → ""
        printList(mergeTwoLists(buildList(new int[]{}), buildList(new int[]{})));

        // Test 3: [] + [0] → "0"
        printList(mergeTwoLists(buildList(new int[]{}), buildList(new int[]{0})));

        // Test 4: [5] + [1,2,3] → "1 -> 2 -> 3 -> 5"
        printList(mergeTwoLists(buildList(new int[]{5}), buildList(new int[]{1,2,3})));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // ============================================
    // LINKED LIST — PROBLEM 2: Merge Two Sorted Lists
    // ============================================
    // Given the heads of two sorted linked lists,
    // merge them into one sorted list by splicing
    // the nodes together (don't create new nodes).
    //
    // Example:
    //   list1: 1 -> 2 -> 4
    //   list2: 1 -> 3 -> 4
    //   result: 1 -> 1 -> 2 -> 3 -> 4 -> 4 
    //
    // Rules:
    //   - O(n + m) time, O(1) space
    // ============================================
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode lastNode = dummyNode;
        ListNode result = lastNode;
        while(list1 != null) {
            if (list2 != null) {
                // compare nodes of list1 and list2 and add the lesser value
                int a = list1.val;
                int b = list2.val;
                if(a < b) {
                    // add list1 node to result and remove that node in list1
                    // result = -1 -> 0 -> null
                    // store lastNode 
                    // Add lastNode.next with current list1Node
                    // update lastNode with current list1Node
                    ListNode temp1 = list1.next;
                    ListNode dummy  = new ListNode(a);
                    if(lastNode == null) {
                        lastNode = dummy;
                    } else {
                        lastNode.next = dummy;
                        lastNode = lastNode.next;
                    }
                    list1 = temp1;
                } else {
                    ListNode temp1 = list2.next;
                    ListNode dummy = new ListNode(b);
                    if(lastNode == null) {
                        lastNode = dummy;
                    } else {
                        lastNode.next = dummy;
                        lastNode = lastNode.next;
                    }
                    list2 = temp1;
                }
            } else {
                // Add all of list1 to result
                if(lastNode == null) {
                    lastNode = list1;
                } else {
                    lastNode.next = list1;
                }
                list1 = null;
            }
        }
        if(list2 != null) {
            if(lastNode == null) {
                lastNode = list2;
            } else {
                lastNode.next = list2;
            }
        }
        return result.next;
    }

    static ListNode buildList(int[] vals) {
        if (vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]);
        ListNode curr = head;
        for (int i = 1; i < vals.length; i++) {
            curr.next = new ListNode(vals[i]);
            curr = curr.next;
        }
        return head;
    }

    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
