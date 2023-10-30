class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        for (int i=temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            } else if (stack.peek()[0] > temperatures[i]) {
                result[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{temperatures[i], i});
        }

        return result;
    }
}