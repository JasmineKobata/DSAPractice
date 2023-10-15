class Solution {
    public int numTilings(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(1);
        dp.add(2);
        dp.add(5);

        for (int i=3; i < n; i++) {
            dp.add((dp.get(i-1)*2 + dp.get(i-3)) % 1000000007);
        }
        System.out.println(dp);
        return dp.get(dp.size() - 1);
    }
}