class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q.add(root);
        boolean xfound = false, yfound = false;
        TreeNode headFound = new TreeNode();

        while (!q.isEmpty()) {
            TreeNode node = q.remove();

            if (node.left != null) {
                if (headFound != node) {
                    if (node.left.val == x) {
                        xfound = true;
                        headFound = node;
                    }
                    if (node.left.val == y) {
                        yfound = true;
                        headFound = node;
                    }
                }
                q2.add(node.left);
            }
            if (node.right != null) {
                if (headFound != node) {
                    if (node.right.val == x) {
                        xfound = true;
                        headFound = node;
                    }
                    if (node.right.val == y) {
                        yfound = true;
                        headFound = node;
                    }
                }
                q2.add(node.right);
            }

            if (q.isEmpty()) {

                if (xfound && yfound) return true;
                else if (xfound || yfound) return false;
                
                q = q2;
                q2 = new LinkedList<>();
            }
        }
        return false;
    }
}