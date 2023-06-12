class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length != word2.length) return false;

        HashMap<Character, Integer> freq1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> freq2 = new HashMap<Character, Integer>();

        for (int i=0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            if (!freq1.containsKey(c)) freq1.put(c, 0);

            freq1.put(c, freq1.get(c)+1);
        }
        for (int i=0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            if (!freq2.containsKey(c)) freq2.put(c, 0);

            freq2.put(c, freq2.get(c)+1);
        }

        for (int i=0; i < word1.length(); i++) {
            
        }

        return freq1.values() == freq2.values();
    }
}