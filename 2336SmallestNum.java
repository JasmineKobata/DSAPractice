class SmallestInfiniteSet {
    int smallest;
    PriorityQueue<Integer> minHeap;

    public SmallestInfiniteSet() {
        smallest = 1;
        minHeap = new PriorityQueue<Integer>();
    }
    
    public int popSmallest() {
        return !minHeap.isEmpty() ? minHeap.poll() : smallest++;
    }
    
    public void addBack(int num) {
        if (num < smallest && !minHeap.contains(num)) minHeap.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */