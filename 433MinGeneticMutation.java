class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<>();
        q.add(startGene);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(startGene, 0);

        while (!q.isEmpty()) {
            String elem = q.remove();
            if (elem.equals(endGene)) {
                return map.get(elem);
            }

            for (int i=0; i < bank.length; i++) {
                if (!map.containsKey(bank[i]) && mutationPossible(elem, bank[i])) {
                    q.add(bank[i]);
                    map.put(bank[i], map.get(elem) + 1);
                }
            }
        }
        return -1;
    }

    private boolean mutationPossible(String s1, String s2) {
        int diff = 0;
        for (int i=0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return diff == 1;
    }
}