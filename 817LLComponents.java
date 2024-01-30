class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = nums.length;

        for (int num : nums) set.add(num);

        ListNode it = head;
        while (it != null) {
            if (it.next != null && set.contains(it.val) && set.contains(it.next.val)) {
                count--;
            }
            
            it = it.next;
        }
        return count;
    }
}