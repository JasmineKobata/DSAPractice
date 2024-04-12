class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode start = head;
        int i = 1;

        while (i < left - 1) {
            start = start.next;
            i++;
        }
        ListNode end = start.next;
        while (i < right-1) {
            if (left == 1) {
                ListNodee
            } else {
                ListNode temp = end.next;
                end.next = temp.next;
                temp.next = start.next;
                start.next = temp;
            }
            i++;
        }
        return head;
    }
}