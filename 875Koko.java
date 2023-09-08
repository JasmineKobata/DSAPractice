class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = piles.length-1;
        while (start < end) {
            int mid = start + (end - start) / 2;
        }
    }

    public hoursToEat(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            while (pile > 0) {
                h += 1;
                pile -= k;
            }
        }
        return hours;
    }
}