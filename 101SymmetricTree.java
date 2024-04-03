class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return parseTree(root.left, root.right);
    }

    public boolean parseTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return left.val == right.val && parseTree(left.left, right.right) && parseTree(left.right, right.left);
    }
}