class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> numOfOccurrences = new HashMap<Integer, Integer>();

        for (int i=0; i < arr.length; i++) {
            int count = numOfOccurrences.containsKey(arr[i]) ? numOfOccurrences.get(arr[i]) : 0;
            numOfOccurrences.put(arr[i], count + 1);
        }

        Integer[] values = numOfOccurrences.values().toArray(Integer[]::new);
        Set<Integer> occurrences = new HashSet<Integer>();
        for (int i=0; i < values.length; i++) {
            if (occurrences.contains(values[i])) {
                return false;
            }
            occurrences.add(values[i]);
        }
        return true;
    }
}