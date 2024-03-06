class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        parseTree(root, result);
        return result;
    }

    public void parseTree(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        parseTree(root.left, result);
        parseTree(root.right, result);
    }
}