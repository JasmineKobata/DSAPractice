class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        Queue<TreeNode> q2 = new LinkedList<>();

        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            level.add(node.val);

            if (node.left != null) q2.add(node.left);
            if (node.right != null) q2.add(node.right);

            if (q.isEmpty()) {
                result.add(level);
                level = new ArrayList<>();
                q = q2;
                q2 = new LinkedList<>();
            }
        }
        return result;
    }
}