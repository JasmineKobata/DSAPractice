class Solution {
    int lastVal = Integer.MIN_VALUE;
    boolean valSet = false;

    public boolean isValidBST(TreeNode root) {
        return parseTree(root);
    }

    public boolean parseTree(TreeNode root) {
        if (root == null) return true;

        boolean result = parseTree(root.left);
        System.out.println(root.val + " " + lastVal);
        if (valSet && lastVal >= root.val) {
            return false;
        }
        lastVal = root.val;
        valSet = true;
        result &= parseTree(root.right);
        
        return result;
    }
}