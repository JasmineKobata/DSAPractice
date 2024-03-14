class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        parseTree(root, 0);
        return sum;
    }

    private void parseTree(TreeNode root, int currentNum) {
        if (root == null) return;

        currentNum = currentNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += currentNum;
            return;
        }

        parseTree(root.left, currentNum);
        parseTree(root.right, currentNum);
    }
}