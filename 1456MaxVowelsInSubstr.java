class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int maxNum = 0;

        for (int i=0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) { maxNum++; }
        }

        int currNum = maxNum;
        for (int i=k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i-k))) { currNum--; }
            if (vowels.contains(s.charAt(i))) { currNum++; }

            maxNum = Math.max(maxNum, currNum);
        }

        return maxNum;
    }
}