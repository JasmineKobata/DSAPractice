class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/");
        String newStr = "";

        for (String token : tokens) {
            if (!token.equals("") && !token.equals("..") && !token.equals(".")) {
                stack.add(token);
            } else if (token.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            newStr = "/" + stack.pop() + newStr;
        }

        return newStr.length() == 0 ? "/" : newStr;
    }
}