class Solution {
    public String removeStars(String s) {
        Stack<Character> str = strToStack(s);
        Stack<Character> result = new Stack<Character>();
        while (!str.isEmpty()) {
            if (str.peek() == '*') {
                str.pop();
                result.pop();
            } else {
                result.push(str.pop());
            }
        }

        return stackToStr(result);
    }

    public Stack<Character> strToStack(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i = s.length() - 1;
        while (i >= 0) {
            stack.push(s.charAt(i));
            i--;
        }
        return stack;
    }

    public String stackToStr(Stack<Character> stack) {
        String s = "";
        while (!stack.isEmpty()) {
            s = stack.pop() + s;
        }
        return s;
    }
}