class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head.next.next;
        ListNode left = null, right = null;

        while (fast != null && fast.next != null) {
            ListNode temp = left;
            left = slow;
            left.next = temp;
            slow = slow.next;
            fast = fast.next.next;
        }
    }
}