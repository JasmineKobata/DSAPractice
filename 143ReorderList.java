/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//reverse up to middle node
//s    f
//1 -> 2 -> 3 -> 4
//     s         f
//1 -> 2 -> 3 -> 4
//l       h  r
//2 -> 1, 3, 4
//l  h       r
//1, 2 -> 3, 4
//3 <- 2 <- 4 <- 1
//s    f
//1 -> 2 -> 3 -> 4 -> 5
//2 -> 1, 3, 4 -> 5
//3 -> 4 -> 2 -> 5 -> 1
//build list in reverse order, alternating

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head.next.next;
        ListNode left = null, right = null;

        while (fast != null) {
            ListNode temp = left;
            left = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
            left.next = temp;
        }
        right = slow;
        // if (fast == null) {
        //     head = left;
        //     left = left.next;
        //     head.next = null;
        // } else {
        //     head = right;
        //     right = right.next;
        //     head.next = null;
        // }
        System.out.println(left.val + " " + head.val + " " + right.val);
    }
}