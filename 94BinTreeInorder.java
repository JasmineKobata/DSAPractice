class Solution {
    List<Integer> results = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        parseTree(root);
        return results;
    }

    public void parseTree(TreeNode root) {
        if (root == null) return;

        parseTree(root.left);
        results.add(root.val);
        parseTree(root.right);
    }
}