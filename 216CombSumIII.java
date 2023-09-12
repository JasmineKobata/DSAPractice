class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        
        parseArray(new ArrayList<Integer>(), k, n);
        return result;
    }

    public void parseArray(List<Integer> nums, int k, int n) {
        if (k == 0) {
            System.out.println(nums);
            if (getSum(nums) == n) result.add(nums);
            return;
        }
        
        for (int i=0; i < 9; i++) {
            nums.add(i);
            parseArray(nums, k-1, n);
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