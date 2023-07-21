class Solution {
	public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        else if (root.left != null && root.left.val == key) {
            root.left = processNode(root.left);
            return root;
        } else if (root.right != null && root.right.val == key) {
            root.right = processNode(root.right);
            return root;
        }

        if (key < root.val) {
            return deleteNode(root.left, key);
        }
        return deleteNode(root.right, key);
    }

    public TreeNode processNode(TreeNode root) {
        return root.right != null ? root.right : root.left;
    }
}