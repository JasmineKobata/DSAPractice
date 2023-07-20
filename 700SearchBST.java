class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        TreeNode result = null;
        if (left != null) result = left;
        if (right != null) result = right;
        return result;
    }
}