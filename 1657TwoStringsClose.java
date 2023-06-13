class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        HashMap<Character, Integer> diff1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> diff2 = new HashMap<Character, Integer>();

        for (int i=0; i < word1.length(); i++) {
            char c = word1.charAt(i);

            if (!diff1.containsKey(c)) diff1.put(c, 0);
            diff1.put(c, diff1.get(c)+1);
        }
        for (int i=0; i < word2.length(); i++) {
            char c = word2.charAt(i);

            if (!diff2.containsKey(c)) diff2.put(c, 0);
            diff2.put(c, diff2.get(c)+1);
        }

        List<Integer> freq1 = new ArrayList<Integer>(diff1.values());
        List<Integer> freq2 = new ArrayList<Integer>(diff2.values());
        Collections.sort(freq1);
        Collections.sort(freq2);
        List<Character> vals1 = new ArrayList<Character>(diff1.keySet());
        List<Character> vals2 = new ArrayList<Character>(diff2.keySet());
        Collections.sort(vals1);
        Collections.sort(vals2);

        return freq1.equals(freq2) && vals1.equals(vals2);
    }
}