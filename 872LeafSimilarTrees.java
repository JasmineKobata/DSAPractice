import java.util.Vector;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Vector<Integer> leaves1 = new Vector<Integer>();
        Vector<Integer> leaves2 = new Vector<Integer>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        if (leaves1.size() != leaves2.size()) return false;

        for (int i=0; i < leaves1.size(); i++) {
            if (leaves1.get(i) != leaves2.get(i)) return false;
        }

        return true;
    }

    public void getLeaves(TreeNode root, Vector<Integer> leaves) {
        if (root == null) return;
        if (isLeaf(root)) leaves.add(root.val);

        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }

    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}