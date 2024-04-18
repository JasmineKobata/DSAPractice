class Solution {
public:
    void sortColors(vector<int>& nums) {
        int min = 0, max = nums.size()-1;
        
        for (int i=0; i<=max; ) {
            if (nums[i] == 0) {
                swap(nums[i], nums[min]);
                min++;
                i++;
            }
            else if (nums[i] == 1) {
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums[i], nums[max]);
                max--;
            }
        }
    }
};