class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode oddTail = head;
        ListNode iter = head.next;
        ListNode evenHead = head.next;

        while (oddIt != null && iter.next != null) {
            evenHead = oddTail.next;
            oddTail.next = iter.next;

            ListNode evenTail = iter;
            iter = iter.next;
            evenTail.next = iter.next
            iter.next = evenHead;

            oddTail = oddTail.next;
            iter = evenTail.next;
        }

        return head;
    }
}