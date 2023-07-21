class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(Arrays.asList(root));
        int resultSum = Integer.MIN_VALUE;
        int resultLayer = 0;

        for (int layer = 1; !queue.isEmpty(); layer++) {
            int currentSum = 0;
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.remove();
                currentSum += node.val;
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
            if (currentSum > resultSum) {
                resultSum = currentSum;
                resultLayer = layer;
            }
        }

        return resultLayer;
    }
}