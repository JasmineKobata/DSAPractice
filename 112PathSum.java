class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return parseTree(root, targetSum, 0);
    }

    private boolean parseTree(TreeNode root, int targetSum, int currentSum) {
        if (root == null) return false;

        currentSum += root.val;
        if (currentSum == targetSum && root.left == null && root.right == null) return true;
        return parseTree(root.left, targetSum, currentSum) | parseTree(root.right, targetSum, currentSum);
    }
}