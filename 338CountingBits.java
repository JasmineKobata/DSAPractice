class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for (int i=0; i <= n; i++) {
            int shiftNum = i;
            int count = 0;
            while (shiftNum > 0) {
                count += shiftNum & 0x0001;
                shiftNum >>= 1;
            }
            result[i] = count;
        }

        return result;
    }
}