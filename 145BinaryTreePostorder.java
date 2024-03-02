class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        parseTree(root, result);
        return result;
    }

    public void parseTree(TreeNode root, List<Integer> result) {
        if (root == null) return;

        parseTree(root.left, result);
        parseTree(root.right, result);
        result.add(root.val);
    }
}