class Solution {
    public int longestZigZag(TreeNode root) {
        char c = 'e'; //looking for e = either, l = left, r = right node
        return parseTree(root, c, 0);
    }

    public int parseTree(TreeNode root, char c, int startVal) {
        if (root == null) return -1;

        int rStartVal = 0;
        int lStartVal = 0;
        if (c == 'e') {
            
        } else if (c == 'l') {
            lStartVal = startVal;
        } else if (c == 'r') {
            rStartVal = startVal;
        }

        return Math.max(1 + parseTree(root.left, 'r', lStartVal),
            1 + parseTree(root.right, 'l', rStartVal));
    }
}