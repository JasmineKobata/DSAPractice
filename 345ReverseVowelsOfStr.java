import java.util.*;

class Solution {
    public String reverseVowels(String s) {
        char[] string = s.toCharArray();
        Set vowels = new HashSet(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        int i = 0, u = string.length-1;
        while (i < u) {
            if (vowels.contains(string[i]) && vowels.contains(string[u])) {
                char temp = string[i];
                string[i] = string[u];
                string[u] = temp;
                i++;
                u--;
            } else {
                if (!vowels.contains(string[i])) { i++; }
                if (!vowels.contains(string[u])) { u--; }
            }
        }

        return new String(string);
    }
}