class Node {
    int val;
    Node next;

    public Node(int newVal) {
        val = newVal;
        next = null;
    }
}

class MyLinkedList {
    Node list;

    public MyLinkedList() {
        list = null;
    }
    
    public int get(int index) {
        Node it = list;
        int i = 0;
        while (it != null && i < index) {
            it = it.next;
            i++;
        }
        return it == null ? -1 : it.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = list;
        list = newNode;
    }
    
    public void addAtTail(int val) {
        if (list == null) list = new Node(val);
        else {
            Node it = list;
            while (it.next != null) {
                it = it.next;
            }
            it.next = new Node(val);
        }
    }
    
    public void addAtIndex(int index, int val) {
        if (index == 0) addAtHead(val);
        else {
            Node it = list;
            int i = 0;
            while (it != null && i < index) {
                if (i == index - 1) {
                    Node newNode = new Node(val);
                    newNode.next = it.next;
                    it.next = newNode;
                }
                it = it.next;
                i++;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index == 0) list = list.next;
        else {
            Node it = list;
            int i = 0;
            while (it != null && i < index) {
                if (it.next != null && i == index - 1) {
                    it.next = it.next.next;
                }
                it = it.next;
                i++;
            }
        }
    }
}