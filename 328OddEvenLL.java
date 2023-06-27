class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode oddTail = head;
        ListNode oddIt = head.next;
        ListNode evenHead = head.next;

        while (oddIt != null && oddIt.next != null) {
            //1 -> 3 -> 2 -> 4 -> 5
            evenHead = oddTail.next;
            oddTail.next = oddIt.next;
            //1 -> 3 -> 5
            //2 -> 4 -> 5
            //1 -> 3 -> 5 -> 2 -> 4
            ListNode temp = oddIt; // 4
            oddIt = oddIt.next; // 5
            temp.next = oddIt.next; // null
            oddIt.next = evenHead; // 4 -> null
            //1 -> 3 -> 5 -> 4 -> null
            oddTail = oddTail.next; // 3
            oddIt = temp.next; // 4
            System.out.println(oddTail.val);
            if (oddIt != null) System.out.println(oddIt.val);
        }

        return head;
    }
}