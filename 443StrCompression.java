class Solution {
    public int compress(char[] chars) {
        int u = 0, count = 1;
        for (int i=0; i < chars.length; i++) {
            if (i > chars.length - 2 || chars[i] != chars[i+1]) {
                chars[u++] = chars[i];
                if (count > 1) {
                    String s = Integer.toString(count);
                    for (char c : s.toCharArray())
                        chars[u++] = c;
                }
                count = 0;
            }
            count++;
        }
        return u;
    }
}