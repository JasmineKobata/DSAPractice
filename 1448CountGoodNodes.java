class Solution {
    public int goodNodes(TreeNode root) {
        return itNode(root, root.val);
    }

    public int itNode(TreeNode root, int maxNum) {
        if (root == null) return 0;

        if (root.val >= maxNum) {
            return 1 + itNode(root.left, root.val) + itNode(root.right, root.val);
        }
        return itNode(root.left, maxNum) + itNode(root.right, maxNum);
    }
}