class Solution {
    HashMap<Character, String> map = new HashMap<>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    List<String> strings = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        parseString(digits, new String());
        return strings;
    }

    public void parseString(String digits, String str) {
        if (digits.length() == 0) {
            strings.add(str);
            return;
        };

        for (Character c : map.get(digit.charAt(0))) {
            parseString(digits, str + c);
        }
    }
}