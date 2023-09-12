class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        
        parseArray(new ArrayList<Integer>(), 1, k, n);
        return result;
    }

    public void parseArray(List<Integer> nums, int start, int k, int n) {
        if (k == 0) {
            if (getSum(nums) == n) result.add(new ArrayList<>(nums));
            return;
        }
        
        for (int i=start; i < 10; i++) {
            nums.add(i);
            parseArray(nums, i+1, k-1, n);
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