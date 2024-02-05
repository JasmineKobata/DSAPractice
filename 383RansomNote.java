class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                int freq = map.get(c);
                if (freq == 0) return false;
                map.replace(c, freq - 1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}