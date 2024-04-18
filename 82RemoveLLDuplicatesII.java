class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        int val = head.next.val;
        while (head != null && head.val == val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head != null && head.next != null) {
                val = head.next.val;
        }
        }

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && slow.next != null
            && fast != null && fast.next != null) {

            if (slow.next.next != null && slow.next.val == slow.next.next.val) {
                fast = slow.next;
                while (fast.next != null && fast.next.val == slow.next.val) {
                    fast = fast.next;
                }
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
        }

        return head;
    }
}