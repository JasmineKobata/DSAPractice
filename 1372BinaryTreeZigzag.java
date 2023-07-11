class Solution {
    Integer max = 0;

    public int longestZigZag(TreeNode root) {
        char c = 'e'; //looking for e = either, l = left, r = right node
        parseTree(root, c, 0);
        return max;
    }

    public void parseTree(TreeNode root, char c, int val) {
        if (root == null) {
            // max = Math.max(val, max);
            return;
        }

        if (c == 'e') {
            parseTree(root.left, 'r', val + 1);
            parseTree(root.right, 'l', val + 1);
        }
        if (c == 'l') {
            parseTree(root.left, 'r', val + 1);
            parseTree(root.right, 'l', 1);
        }
        if (c == 'r') {
            parseTree(root.left, 'r', 1);
            parseTree(root.right, 'l', val + 1);
        }

        max = Math.max(val, max);
        return;
    }
}