using namespace std;

struct Comparator {
    bool operator() (tuple<int, char>& t1, tuple<int, char>& t2) {
        return get<1>(t1) > get<1>(t2);
    }
};

class Solution {
public:
    int firstUniqChar(string s) {
        map<char, int> set;
        
        for (char c : s) {
            set[c]++;
        }
        
        for (int i=0; i<s.length(); i++) {
            if (set[s[i]] == 1) {
                return i;
            }
        }
        
        return -1;
    }
};