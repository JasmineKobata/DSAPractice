class MyQueue {
public:
    stack<int> s1, s2;
    
    MyQueue() {
    }
    
    void push(int x) {
        int s2size = s2.size();
        for (int i=0; i<s2size; i++) {
            s1.push(s2.top());
            s2.pop();
        }
        s1.push(x);
    }
    
    int pop() {
        int s1size = s1.size();
        for (int i=0; i<s1size; i++) {
            s2.push(s1.top());
            s1.pop();
        }
        int num = s2.top();
        s2.pop();
        return num;
    }
    
    int peek() {
        int s1size = s1.size();
        for (int i=0; i<s1size; i++) {
            s2.push(s1.top());
            s1.pop();
        }
        return s2.top();
    }
    
    bool empty() {
        return s1.empty() && s2.empty();
    }
};