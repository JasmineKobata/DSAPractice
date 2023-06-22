class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;

        while (i < asteroids.length) {
            if (stack.isEmpty() || !willCollide(stack.peek(), asteroids[i])) {
                stack.push(asteroids[i]);
            } else {
                if (Math.abs(asteroids[i]) >= Math.abs(stack.peek())) {
                    stack.pop();
                }
            }
            i++;
        }

        i = stack.size() - 1;
        int[] res = new int[i+1];
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i--;
        }

        return res;
    }

    public boolean willCollide(int num1, int num2) {
        return num1 > 0 && num2 < 0;
    }
}