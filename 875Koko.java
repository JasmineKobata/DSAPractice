class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;

        for (int pile : piles) {
            if (pile > max) max = pile;
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            int midHrs = hoursToEat(piles, mid);
            if (midHrs > h) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public int hoursToEat(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double)pile / k);
        }
        return hours;
    }
}