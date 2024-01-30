class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        return isSubroot(root, subRoot) || isSubtree(root.left, subRoot)|| isSubtree(root.right, subRoot);
    }

    private boolean isSubroot(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;

        return isSubroot(root.left, subRoot.left) && isSubroot(root.right, subRoot.right);
    }
}