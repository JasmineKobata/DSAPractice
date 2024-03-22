class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.remove();
            if (!q.isEmpty()) node.next = q.peek();

            if (node.left != null) q2.add(node.left);
            if (node.right != null) q2.add(node.right);

            if (q.isEmpty()) {
                q = q2;
                q2 = new LinkedList<>();
            }
        }
        return root;
    }
}