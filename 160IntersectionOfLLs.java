public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int idxA = getLen(headA);
        int idxB = getLen(headB);

        for (int i=0; i < Math.abs(idxA - idxB); i++) {
            if (idxA > idxB)
                headA = headA.next;
            else
                headB = headB.next;
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    int getLen(ListNode head) {
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        return i;
    }
}