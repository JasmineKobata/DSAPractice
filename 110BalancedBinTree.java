class Solution {
    Boolean bool = true;
    public boolean isBalanced(TreeNode root) {
        parseTree(root);
        return bool;
    }

    public int parseTree(TreeNode root) {
        if (root == null) return 0;

        int left = parseTree(root.left);
        int right = parseTree(root.right);
        bool &= Math.abs(left - right) <= 1;
        return 1 + Math.max(left, right);
    }
}