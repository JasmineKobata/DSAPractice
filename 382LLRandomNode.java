class Solution {
    private ListNode list = new ListNode();

    public Solution(ListNode head) {
        list = head;
    }
    
    public int getRandom() {
        ListNode it = list;
        List<Integer> intlist = new ArrayList<>();
        while (it != null) {
            intlist.add(it.val);
            it = it.next;
        }

        Random rand = new Random();
        return intlist.get(rand.nextInt(intlist.size()));
    }
}
