class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        unordered_set<char> set;
        vector<vector<int>> visited(board.size(), vector<int>(board[0].size(), 0));
        
        for (char c : word) {
            set.insert(c);
        }
        
        for (int i=0; i<board.size(); i++) {
            for (int u=0; u<board[i].size(); u++) {
                if (parseGrid(board, word, i, u, 0, visited, set)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    bool parseGrid(vector<vector<char>>& board, string word, int i, int u, int wordIdx, vector<vector<int>>& visited, unordered_set<char>& set) {
        if (wordIdx == word.length())
            return true;
        
        if (i<0 || i>=board.size() || u<0 || u>=board[0].size() || word[wordIdx] != board[i][u] || visited[i][u]) {
            return false;
        }
        
        visited[i][u] = true;
        
        if (parseGrid(board, word, i-1, u, wordIdx + 1, visited, set)
           || parseGrid(board, word, i+1, u, wordIdx + 1, visited, set)
           || parseGrid(board, word, i, u-1, wordIdx + 1, visited, set)
           || parseGrid(board, word, i, u+1, wordIdx + 1, visited, set)) {
            return true;
        }
        
        if (set.find(board[i][u]) != set.end())
            visited[i][u] = false;
        
        return false;
    }
};