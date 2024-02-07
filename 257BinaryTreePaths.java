class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> v;
        string s;
        
        if (!root)
            return v;
        
        s.append(to_string(root->val));
        
        if (!root->left && !root->right) {
            v.push_back(s);
        }
        
        parseTree(root->left, v, s);
        parseTree(root->right, v, s);
        return v;
    }
    
    void parseTree(TreeNode* root, vector<string>& v, string s) {
        if (!root) {
            return;
        }
        s.append("->");
        s.append(to_string(root->val));
        
        if (!root->left && !root->right) {
            v.push_back(s);
            return;
        }
    
        if (root->left != NULL)
            parseTree(root->left, v, s);
        if (root->right != NULL)
            parseTree(root->right, v, s);
    }
};