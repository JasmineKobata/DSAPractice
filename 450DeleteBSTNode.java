class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;


        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = minNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public TreeNode minNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}