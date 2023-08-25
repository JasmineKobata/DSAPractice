class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int pLen = potions.length;
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        System.out.println(Arrays.toString(potions));

        for (int i=0; i < spells.length; i++) {
            int start = 0, end = pLen;
            int mid = pLen / 2;
            System.out.println("A " + mid);
            while (mid < pLen && mid > 0
                && (spells[i] * potions[mid] < success
                || spells[i] * potions[mid-1] >= success)) {
                if (spells[i] * potions[mid] < success) {
                    mid = (end - mid - 1) / 2 + mid + 1;
                    System.out.println("Q " + mid);
                }
                else if (spells[i] * potions[mid] > success) {
                    end = mid;
                    mid /= 2;
                }
                System.out.println("B " + mid);
            }
            System.out.println("C " + pLen + " " + mid);
            if (mid < 0) pairs[i] = pLen;
            else if (mid >= pLen) pairs[i] = 0;
            else pairs[i] = pLen - mid;
        }
        System.out.println(Arrays.toString(pairs));
        return pairs;
    }
}