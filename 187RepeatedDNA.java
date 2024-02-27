class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //int list to return
        Set<String> set = new HashSet<String>();
        Set<String> list = new HashSet<>();
        //iterate through string
        for (int i=0; i < s.length()-9; i++) {
            //get substring at i
            String substr = s.substring(i, i+10);
            //if substr doesn't exist in list add to list
            if (!set.contains(substr)) {
                set.add(substr);
            }
            //else add substr to list
            else {
                list.add(substr);
            }
        }

        return new ArrayList(list);
    }
}