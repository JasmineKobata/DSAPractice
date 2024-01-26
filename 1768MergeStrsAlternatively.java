class Solution {
public:
    string mergeAlternately(string word1, string word2) {
        string s = "";

        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            s = s + word1[i] + word2[i++];
        }

        return s + word1.substr(i) + word2.substr(i);
    }
};