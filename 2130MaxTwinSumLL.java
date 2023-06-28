class Solution {
    public int pairSum(ListNode head) {
        if (head == null || head.next == null) return -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ListNode slow = head;
        ListNode fast = head;

        int i = 0, result = 0;
        while (fast != null && fast.next != null) {
            map.put(i++, slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            result = Math.max(result, map.get(--i) + slow.val);
            slow = slow.next;
        }
        return result;
    }
}