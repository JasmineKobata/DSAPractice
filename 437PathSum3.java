class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Queue<Integer> q = new LinkedList<Integer>();
        return itNode(root, targetSum, q, null);
    }

    public int itNode(TreeNode root, int targetSum, Queue<Integer> queue, Integer currentSum) {
        if (root == null) return 0;

        currentSum = adjustedQueue(queue, root.val, targetSum, currentSum);
        return (currentSum == targetSum ? 1 : 0) + itNode(root.left, targetSum, queue, currentSum) + itNode(root.right, targetSum, queue, currentSum);
    }

    public Integer adjustedQueue(Queue<Integer> queue, int val, int targetSum, Integer currentSum) {
        queue.add(val);
        if (currentSum == null) currentSum = 0;
        currentSum += val;

        if (!queue.isEmpty()) {
            while (currentSum > targetSum) {
                currentSum -= queue.remove();
            }
        }
        return currentSum;
    }
}