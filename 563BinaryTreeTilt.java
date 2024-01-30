class Solution {
    List<Integer> tilts = new ArrayList<>();

    public int findTilt(TreeNode root) {
        parseTree(root);
        int sum = 0;
        for (int tilt : tilts) {
            sum += tilt;
        }
        return sum;
    }

    public int parseTree(TreeNode root) {
        if (root == null) return 0;
        
        int left = parseTree(root.left);
        int right = parseTree(root.right);
        tilts.add(Math.abs(left - right));
        return root.val + left + right;
    }
}