class Solution {
    public int strStr(String haystack, String needle) {
        for (int i=0; i < haystack.length() - needle.length() + 1; i++) {
            for (int u=0; u < needle.length() && haystack.charAt(i+u) == needle.charAt(u); u++) {
                if (u == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}