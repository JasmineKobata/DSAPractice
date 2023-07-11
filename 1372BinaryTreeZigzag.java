class Solution {
    public int longestZigZag(TreeNode root) {
        char c = 'e'; //looking for e = either, l = left, r = right node
        return parseTree(root, c, 0);
    }

    public int parseTree(TreeNode root, char c, int startVal) {
        if (root == null) return -1;

        int rStartVal = 0;
        int lStartVal = 0;
        if (c == 'e' || c == 'l') {
            lStartVal = parseTree(root.left, 'r', startVal);
        }
        if (c == 'e' || c == 'r') {
            rStartVal = parseTree(root.right, 'l', startVal);
        }

        return Math.max(1 + lStartVal,
            1 + rStartVal);
    }
}