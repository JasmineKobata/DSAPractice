class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return root;

        pruneTree(root.left);
        pruneTree(root.right);
        if (isEmptyLeaf(root.left)) root.left = null;
        if (isEmptyLeaf(root.right)) root.right = null;

        return isEmptyLeaf(root) ? null : root;
    }

    private boolean isEmptyLeaf(TreeNode root) {
        return root != null && root.val == 0 && root.left == null && root.right == null;
    }
}