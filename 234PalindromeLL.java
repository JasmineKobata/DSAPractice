class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if (!head || !head->next) {
            return true;
        }
        
        ListNode *slow = head, *fast = head->next; //measures even
        
        ListNode *tail = head->next;
        head->next = NULL;
        while (fast->next != NULL && fast->next->next != NULL) {
            fast = fast->next->next;
            ListNode *temp = tail->next;
            tail->next = head;
            
            head = tail;
            tail = temp;
        }
        if (fast->next != NULL) {
            tail = tail->next;
        }
        //check if lists are equal;
        while (head != NULL && tail != NULL) {
            if (head->val != tail->val) {
                return false;
            }
            head = head->next;
            tail = tail->next;
        }
        return true;
    }
}