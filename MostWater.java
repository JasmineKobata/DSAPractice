class Solution {
    public int maxArea(int[] height) {
        int maxVol = 0;
        int head = 0, tail = height.length-1;

        while (head < tail) {
            int currentVol = Math.min(height[head], height[tail]) * (tail - head);
            maxVol = Math.max(maxVol, currentVol);

            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }

        return maxVol;
    }
}