class Solution {
    public boolean isIsomorphic(String s, String t) {
        //return false if string length differ
        if (s.length() != t.length()) return false;
        //Create 2 hashmaps for each string
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        //insert freqency int maps
        for (int i=0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (mapS.containsKey(sc) && mapT.containsKey(tc)) {
                if (mapS.get(sc) != tc || mapT.get(tc) != sc) return false;
            } else if (!mapS.containsKey(sc) && !mapT.containsKey(tc)){
                mapS.put(sc, tc);
                mapT.put(tc, sc);
            } else {
                return false;
            }
        }
        //exit & return true;
        return true;
    }
}