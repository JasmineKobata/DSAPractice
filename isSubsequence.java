class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0, sLen = s.length(), tLen = t.length();
        if (sLen == 0) { return true; }

        for (int tIdx=0; tIdx < tLen; tIdx++) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
                if (sIdx >= sLen) { return true; }
            }
        }

        return sIdx >= sLen;
    }
}