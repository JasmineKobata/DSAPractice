class BSTIterator {
    TreeNode node = new TreeNode();
    Queue<Integer> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        node = root;
        parseTree(root);
    }
    
    public int next() {
        return list.remove();
    }
    
    public boolean hasNext() {
        return list.size() > 0;
    }

    private void parseTree(TreeNode node) {
        if (node == null) return;

        parseTree(node.left);
        list.add(node.val);
        parseTree(node.right);
    }
}