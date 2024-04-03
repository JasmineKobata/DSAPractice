class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        isBalanced(root.left);
        isBalanced(root.right);

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxHeight(root.left) - maxHeight(root.right)) <= 1;
    }

    public int maxHeight(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}