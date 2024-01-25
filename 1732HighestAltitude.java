class Solution {
    public int largestAltitude(int[] gain) {
        int currentAlt = 0;
        int maxAlt = 0;

        for (int i=0; i < gain.length; i++) {
            currentAlt += gain[i];
            maxAlt = Math.max(currentAlt, maxAlt);
        }

        return maxAlt;
    }
}