class Solution {
    public int tribonacci(int n) {
        List<Integer> dp = new ArrayList<>(Arrays.asList(0, 1, 1));
        if (n < 3) return dp.get(n);

        int sum = 0;
        for (int i=1; i < 3; i++) { sum += dp.get(i-1); }

        for (int i=3; i <= n; i++) {
            if (i > 3) sum -= dp.get(i-4);
            sum += dp.get(i-1);
            dp.add((Integer)sum);
        }
        return sum;
    }
}