class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int len = spells.length;
        int[] pairs = new int[len];

        for (int i=0; i < len; i++) {
            int mid = (len + 1) / 2;
            System.out.println("A " + mid);
            while (mid < len && mid >= 0
                && (spells[i] * potions[mid] < success
                || spells[i] * potions[mid-1] >= success)) {
                if (spells[i] * potions[mid] < success) {
                    mid = (len - mid) / 2 + mid + 1;
                    System.out.println("Q " + mid);
                }
                else if (spells[i] * potions[mid] > success) mid /= 2;
                System.out.println("B " + Integer.toString(mid));
                // System.out.print(spells[i]);
                // System.out.print(" ");
                // System.out.println(mid);
            }
            // System.out.println("C " + spells[i] * potions[mid]);
            if (mid < len) pairs[i] = len;
            else if (mid >= 0) pairs[i] = 0;
            else pairs[i] = len - mid;
        }
        return pairs;
    }
}