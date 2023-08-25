class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int pLen = potions.length;
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);

        for (int i=0; i < spells.length; i++) {
            int start = 0, end = pLen;
            int mid = pLen / 2;
            while (mid < pLen && mid > 0
                && ((long)spells[i] * potions[mid] < success
                || (long)spells[i] * potions[mid-1] >= success)) {
                if ((long)spells[i] * potions[mid] < success) {
                    mid = (end - mid - 1) / 2 + mid + 1;
                }
                else {
                    end = mid;
                    mid /= 2;
                }
            }
            pairs[i] = pLen - mid;
        }
        return pairs;
    }
}