class Solution {
    public int tribonacci(int n) {
        List<Integer> dp = new ArrayList<Integer>(){1, 2, 3};
        if (n < 3) return dp.get(n);

        int sum = 0;
        for (int i=0; i < n; i++) {
            if (i > 2) {
                sum -= dp.get(n-3);
            }
            sum += dp.get(n);
            dp.add(sum);
        }
        return sum;
    }
}