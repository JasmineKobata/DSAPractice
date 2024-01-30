class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        double sum = 0, width = 0;
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node.left != null) q2.add(node.left);
            if (node.right != null) q2.add(node.right);

            sum += node.val;
            width++;

            if (q.isEmpty()) {
                averages.add(sum / width);
                sum = 0;
                width = 0;
                q = q2;
                q2 = new LinkedList();
            }
        }
        return averages;
    }
}