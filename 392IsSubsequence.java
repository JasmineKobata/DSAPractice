class Solution {
    public boolean isSubsequence(String s, String t) {
        int sidx = 0, tidx = 0;
        while (sidx < s.length() && tidx < t.length()) {
            if (t.charAt(tidx) == s.charAt(sidx)) {
                sidx++;
            }
            tidx++;
        }
        return sidx == s.length();
    }
}