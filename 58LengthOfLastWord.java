class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        int i = strs.length - 1;
        while (strs[i].equals("")) i--;

        return strs[i].length();
    }
}