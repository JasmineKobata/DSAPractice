class Solution {
    int min = Integer.MAX_VALUE;
    int lastVal = 0;
    boolean valSet = false;

    public int getMinimumDifference(TreeNode root) {
        parseTree(root);
        return min;
    }

    private void parseTree(TreeNode root) {
        if (root == null) return;

        getMinimumDifference(root.left);
        if (valSet) {
            min = Math.min(min, root.val - lastVal);
        }
        lastVal = root.val;
        valSet = true;
        getMinimumDifference(root.right);
    }
}