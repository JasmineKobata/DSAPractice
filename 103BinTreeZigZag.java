class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> row = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(root);

        boolean leftIn = true;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            row.add(node.val);

            if (leftIn) {
                if (node.left != null) stack2.push(node.left);
                if (node.right != null) stack2.push(node.right);
            } else {
                if (node.right != null) stack2.push(node.right);
                if (node.left != null) stack2.push(node.left);
            }

            if (stack.isEmpty()) {
                leftIn = !leftIn;
                stack = stack2;
                stack2 = new Stack<>();
                list.add(row);
                row = new ArrayList<>();
            }
        }

        return list;
    }
}