class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        List<String> list = new ArrayList<>();
        for (int i=0; i < strs.length; i++) {
            if (!strs[i].equals("") && !strs[i].equals(" "))
                list.add(strs[i]);
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            String temp = list.get(right);
            list.set(right, list.get(left));
            list.set(left, temp);
            left++;
            right--;
        }

        String result = "";
        for (int i=0; i < list.size(); i++) {
            result += list.get(i);
            if (i < list.size() - 1) result += " ";
        }
        return result;
    }
}