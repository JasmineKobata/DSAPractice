class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return parseTree(root, root.val);
    }

    private boolean parseTree(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;

        return parseTree(root.left, val) && parseTree(root.right,val);
    }
}