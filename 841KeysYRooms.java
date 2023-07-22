class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) return true;
        Set<Integer> visited = new HashSet<Integer>(Arrays.asList(0));
        Queue<List> queue = new LinkedList<List>();
        queue.add(rooms.get(0));

        while (!queue.isEmpty()) {         
            List<Integer> currKey = queue.remove();

            for (int i=0; i<currKey.size(); i++) {
                int roomNum = currKey.get(i);
                if (!visited.contains(roomNum)) {
                    visited.add(roomNum);
                    queue.add(rooms.get(roomNum));
                }
            }
        }

        return visited.size() == rooms.size();
    }
}