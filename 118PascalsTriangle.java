class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        
        List<Integer> newList = new ArrayList<>();
        newList.add(1);
        list.add(newList);

        for (int idx = 1; idx < numRows; idx++) {

            newList = new ArrayList<>();
            newList.add(1);

            int subIdx = 1;
            List<Integer> prevRow = list.get(idx-1);
            while (newList.size() < prevRow.size()) {
                int sum = prevRow.get(subIdx-1) + prevRow.get(subIdx);
                newList.add(sum);
                subIdx++;
            }
            newList.add(1);
            list.add(newList);
        }
        
        return list;
    }
}