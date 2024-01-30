class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode root = null;
        return buildTree(nums, root, 0, nums.length);
    }

    public TreeNode buildTree(int[] nums, TreeNode root, int start, int end) {
        if (start == end) return null;

        int mid = start, max = nums[start];
        for (int i=start; i < end; i++) {
            if (nums[i] > max) {
                mid = i;
                max = nums[i];
            }
        }
        root = new TreeNode(max);
        root.left = buildTree(nums, root.left, start, mid);
        root.right = buildTree(nums, root.right, mid+1, end);
        return root;
    }
}