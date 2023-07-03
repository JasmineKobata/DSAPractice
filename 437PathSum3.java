class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Queue<Integer> q = new LinkedList<Integer>();
        return itNode(root, targetSum, q, 0);
    }

    public int itNode(TreeNode root, int targetSum, Queue<Integer> queue, int currentSum) {
        if (root == null) return 0;

        currentSum += root.val;
        queue.add(root.val);
        return adjustedQueue(queue, targetSum, currentSum) + itNode(root.left, targetSum, new LinkedList<Integer>(queue), currentSum) + itNode(root.right, targetSum, new LinkedList<Integer>(queue), currentSum);
    }

    public int adjustedQueue(Queue<Integer> queue, int targetSum, int currentSum) {
        int targetFound = 0;
        Queue<Integer> qCopy = new LinkedList<Integer>(queue);
// System.out.println(qCopy);
        while (!qCopy.isEmpty()) {
            // System.out.println(currentSum);
            if (currentSum == targetSum) targetFound++;
            currentSum -= qCopy.remove();
        }

        return targetFound;
    }
}