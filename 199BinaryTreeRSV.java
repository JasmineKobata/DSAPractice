class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<Integer>();
        if (root == null) return rightView;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(Arrays.asList(root));
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        rightView.add(queue.peek().val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.right != null) queue2.add(node.right);
            if (node.left != null) queue2.add(node.left);

            if (queue.isEmpty() && !queue2.isEmpty()) {
                rightView.add(queue2.peek().val);
                queue = new LinkedList<TreeNode>(queue2);
                queue2 = new LinkedList<TreeNode>();
            }
        }
        return rightView;
    }
}