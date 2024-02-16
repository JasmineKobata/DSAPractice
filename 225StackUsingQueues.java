class MyStack {
public:
    queue<int> q1, q2;
    
    MyStack() {
        
    }
    
    void push(int x) {
        if (!q1.empty()) {
            q2.push(q1.front());
            q1.pop();
        }
        q1.push(x);
    }
    
    int pop() {
        int num = q1.front();
        q1.pop();
        int q2size = q2.size();

        for (int i=0; i<q2size; i++) {
            if (!q1.empty()) {
                printf("A\n");
                q2.push(q1.front());
                q1.pop();
            }
            if (!q2.empty()) {
                q1.push(q2.front());
                q2.pop();
            }
            printf("%i %i\n", q1.front(), q2.front());
        }
        return num;
    }
    
    int top() {
        return q1.front();
    }
    
    bool empty() {
        return q1.empty();
    }
};