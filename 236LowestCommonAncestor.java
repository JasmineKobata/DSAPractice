class Solution {
    int found = 0;
    int val = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    }

    public void parseTree(TreeNode root1, TreeNode root2, TreeNode p, TreeNode q) {
        if (root == null) return;

        if (root == p || root == q) {
            found++;
        }
        if (found == 2)
        return;
    }
}