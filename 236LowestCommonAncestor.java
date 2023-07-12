class Solution {
    TreeNode val = new TreeNode();
    int found = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parseTree(root, p.val, q.val);
        return val;
    }

    public void parseTree(TreeNode root, int p, int q) {
        if (root == null) return;

        parseTree(root.left, p, q);
        parseTree(root.right, p, q);
        System.out.print(root.val);
        System.out.print(" ");
        System.out.println(found);
        if (found == 2) val = root;
        if (root.val == p || root.val == q || found == 2) found++;

        return;
    }
}