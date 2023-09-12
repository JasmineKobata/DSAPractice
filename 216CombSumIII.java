class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        
        parseArray(new ArrayList<Integer>(), k, n);
        return result;
    }

    public void parseArray(List<Integer> nums, int k, int n) {
        if (k == 0) {
            if (getSum(nums) == n) result.add(new ArrayList<>(nums));
            System.out.println(result);
            return;
        }
        
        for (int i=1; i < 10; i++) {
            nums.add(i);
            parseArray(nums, k-1, n);
            nums.remove(nums.size() - 1);
        }
    }

    public int getSum(List<Integer> nums) {
        int sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}