class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode reverseList = null, result = null;

        while (fast.next != null && fast.next.next != null) {
            ListNode temp = reverseList;
            reverseList = slow;
            reverseList.next = temp;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            ListNode temp = result;
            result = slow.next;
            result.next = temp;
            slow = slow.next;
        }
        ListNode itEnd = slow, itStart = reverseList;
        while (itEnd != null) {
            ListNode temp = result;
            ListNode tempEnd = itEnd;
            ListNode tempStart = itStart;
            itEnd = itEnd.next;
            itStart = itStart.next;
            
        }
    }
}