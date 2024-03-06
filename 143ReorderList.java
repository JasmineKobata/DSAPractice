class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode it = head.next;

        while (it.next != null && it.next.next != null)
            it = it.next;

        ListNode temp = it.next;
        it.next = temp.next;
        temp.next = head.next;
        head.next = temp;
    }
}