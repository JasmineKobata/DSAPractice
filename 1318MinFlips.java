class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;

        while (a > 0 || b > 0 || c > 0) {
            int bitA = a & 0x0001;
            int bitB = b & 0x0001;
            int bitC = c & 0x0001;
            System.out.println(bitC);
            if (bitC == 0x0000 && (bitA & bitB) == 0x0001) {
                System.out.println("A");
                count += 2;
            } else if ((bitC == 0x0001 && (bitA | bitB) == 0x0000)
                || (bitC == 0x0000 && (bitA ^ bitB) == 0x0001)) {
                System.out.println("B");
                count++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return count;
    }
}