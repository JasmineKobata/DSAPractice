class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tail = head;

        while (tail.next != null) {
            ListNode swappedNode = tail.next;
            tail.next = tail.next.next;
            swappedNode.next = head;
            head = swappedNode;
        }

        return head;
    }
}