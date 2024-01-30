class Solution {
    TreeNode newTree = new TreeNode();
    TreeNode newRoot = newTree;

    public TreeNode increasingBST(TreeNode root) {
        parseTree(root);
        return newRoot.right;
    }

    private TreeNode parseTree(TreeNode root) {
        if (root == null) return root;

        parseTree(root.left);

        newTree.right = new TreeNode(root.val);
        newTree = newTree.right;
        
        parseTree(root.right);
        return root;
    }
}