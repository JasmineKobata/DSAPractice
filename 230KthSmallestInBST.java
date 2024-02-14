class Solution {
    int count = 1, val = 0;
    boolean valSet = false;

    public int kthSmallest(TreeNode root, int k) {
        parseTree(root, k);
        return val;
    }

    private void parseTree(TreeNode root, int k) {
        if (valSet || root == null) return;

        parseTree(root.left, k);
        if (!valSet && count == k) {
            val = root.val;
            valSet = true;
        }
        count++;
        parseTree(root.right, k);
    }
}