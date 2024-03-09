class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode slow = head, fast = head.next;
        ListNode left = null, right = null;
        boolean odd = false;

        while (fast != null) {
            ListNode temp = left;
            left = slow;
            slow = slow.next;
            fast = fast.next;
            odd = false;
            if (fast != null) {
                odd = true;
                fast = fast.next;
            }
            left.next = temp;
        }
        right = slow;
        head = right;
        right = right.next;
        head.next = null;
        if (odd) {
            ListNode temp = left;
            left = right;
            right = temp;
        }        

        while (left != null) {
            ListNode temp = left;
            left = left.next;
            temp.next = head;
            head = temp;
            
            temp = left;
            left = right;
            right = temp;
        }
    }
}