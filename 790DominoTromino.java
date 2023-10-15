class Solution {
    public int numTilings(int n) {
        List<Long> dp = new ArrayList<>();
        dp.add(1L);
        dp.add(2L);
        dp.add(5L);

        for (int i=3; i < n; i++) {
            dp.add((dp.get(i-1)*2 + dp.get(i-3)) % 1000000007);
        }
        System.out.println(dp.get(n - 1));
        return dp.get(n - 1).intValue();
    }
}