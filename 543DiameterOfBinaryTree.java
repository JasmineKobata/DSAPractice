class Solution {
    int maxpath = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        parseTree(root);
        return maxpath;
    }

    private int parseTree(TreeNode root) {
        if (root == null) return 0;

        int leftmax = parseTree(root.left);
        int rightmax = parseTree(root.right);
        maxpath = Math.max(maxpath, leftmax + rightmax);
        return 1 + Math.max(leftmax, rightmax);
    }
}