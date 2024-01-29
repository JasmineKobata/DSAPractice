class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        
        for (int u=0; u < strs[0].length(); u++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() <= u || strs[i].charAt(u) != strs[i-1].charAt(u)) {
                    return prefix;
                }
            }

            prefix += strs[0].charAt(u);
        }
        return prefix;
    }
}