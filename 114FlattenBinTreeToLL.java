class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        if (root.left != null) {
            TreeNode right = root.right;
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }
}