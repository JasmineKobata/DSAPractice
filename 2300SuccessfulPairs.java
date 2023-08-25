class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int len = spells.length;
        int[] pairs = new int[len];

        for (int i=0; i < len; i++) {
            int mid = len / 2;
            while (spells[i] * potions[mid] < success
                || spells[i] * potions[mid-1] >= success) {
                if (spells[i] * potions[mid] < success) mid = (len - mid) / 2 + mid;
                else if (spells[i] * potions[mid] > success) mid /= 2;
            }
            pairs[i] = len - mid;
        }
        return pairs;
    }
}