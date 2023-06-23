cclass Solution {
    public String decodeString(String s) {
        String result = "";
        Stack<Integer> numOfRepeats = new Stack<Integer>();
        Stack<String> strToRepeat = new Stack<String>();
        String tempNum = "";
        String tempStr = "";
        int numOfBrackets = 0;
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLetter(c)) {
                if (tempStr.isEmpty() && numOfBrackets == 0) {
                    numOfRepeats.push(1);
                }
                tempStr += c;
            } else if (isNum(c)) {
                if (tempStr.length() > 0) {
                    strToRepeat.push(tempStr);
                    tempStr = "";
                }
                tempNum += c;
            } else if (c == '[') {
                numOfBrackets++;
                numOfRepeats.push(Integer.parseInt(tempNum));
                tempNum = "";
            } else if (c == ']') {
                numOfBrackets--;
                if (tempStr.length() > 0) {
                    strToRepeat.push(tempStr);
                    tempStr = "";
                }
            }

            if (numOfBrackets == 0 && !strToRepeat.isEmpty()) {
                while (!numOfRepeats.empty()) {
                    int u=numOfRepeats.pop();
                    String topElem = strToRepeat.pop();
                    String lastElem = strToRepeat.empty() ? "" : strToRepeat.pop();

                    for (; u > 0; u--) {
                        lastElem += topElem;
                    }
                    strToRepeat.push(lastElem);
                }
                result += strToRepeat.pop();
            }
        }

        if (!tempStr.isEmpty()) {
            result += tempStr;
        }

        return result;
    }

    public boolean isLetter(char c) {
        Set<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        return vowels.contains(c);
    }

    public boolean isNum(char c) {
        Set<Character> num = new HashSet<Character>(Arrays.asList('0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9'));
        return num.contains(c);
    }
}