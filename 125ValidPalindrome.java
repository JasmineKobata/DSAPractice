class Solution {
    public boolean isPalindrome(String s) {
        String alph = "abcdefghijklmnopqrstuvwxyz0123456789";
        Set<Character> set = new HashSet<>();
        for (char c : alph.toCharArray()) set.add(c);
        String newStr = "";

        for (char c : s.toCharArray()) {
            if (set.contains(Character.toLowerCase(c)))
                newStr += Character.toLowerCase(c);
        }

        int left = 0, right = newStr.length()-1;
        while (left < right) {
            if (newStr.charAt(left) != newStr.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}