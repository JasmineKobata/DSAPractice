class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while (!map.containsKey(n)) {
            int sum = 0;
            int save = n;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }

            if (sum == 1) return true;
            map.put(save, sum);
            n = sum;
        }

        return false;
    }
}