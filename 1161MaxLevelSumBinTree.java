class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(Arrays.asList(root));
        int layer = 1;
        int resultSum = Integer.MIN_VALUE;
        int resultLayer = 0;
        int currentSum = 0;
        int size = queue.size();

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            currentSum += node.val;
            size--;
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);

            if (size == 0) {
                size = queue.size();
                if (currentSum > resultSum) {
                    resultSum = currentSum;
                    resultLayer = layer;
                }
                layer++;
                currentSum = 0;
            }
        }

        return resultLayer;
    }
}