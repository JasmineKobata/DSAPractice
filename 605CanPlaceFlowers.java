class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i=0; i < flowerbed.length; i++) {
            boolean isEmpty = flowerbed[i] == 0;
            if (i > 0) {
                isEmpty &= flowerbed[i-1] == 0; 

            }
            if (i < flowerbed.length - 1) {
                isEmpty &= flowerbed[i+1] == 0;
            }
            if (isEmpty) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}