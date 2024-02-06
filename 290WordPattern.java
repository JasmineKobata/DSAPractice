class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] pArr = pattern.split("");
        String[] sArr = s.split(" ");
        if (pArr.length != sArr.length) return false;
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, String> sMap = new HashMap<>();

        for (int i=0; i < pArr.length; i++) {
            if (map.containsKey(pArr[i]) && sMap.containsKey(sArr[i])) {
                if (!map.get(pArr[i]).equals(sArr[i]) && !sMap.get(sArr[i]).equals(pArr[i]))
                    return false;
            } else if (!map.containsKey(pArr[i]) && !sMap.containsKey(sArr[i])) {
                map.put(pArr[i], sArr[i]);
                sMap.put(sArr[i], pArr[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}