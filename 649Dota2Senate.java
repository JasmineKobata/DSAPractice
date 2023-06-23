class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<Character>();
        int rPoints = 0;
        int dPoints = 0;

        for (int i=0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                if (dPoints <= 0) {
                    queue.add(senate.charAt(i));
                    rPoints++;
                } else {
                    dPoints--;
                }
            } else if (senate.charAt(i) == 'D') {
                if (rPoints <= 0) {
                    queue.add(senate.charAt(i));
                    dPoints++;
                } else {
                    rPoints--;
                }
            }
        }

        boolean allSame = true;
        Queue<Character> queue2 = new LinkedList<Character>();
        char lastChar = queue.peek();
        while (!queue.isEmpty()) {
            char c = queue.remove();
            allSame &= (c == lastChar);

            if (c == 'R') {
                if (dPoints <= 0) {
                    lastChar = 'R';
                    queue2.add(c);
                    rPoints++;
                    dPoints = Math.max(0, dPoints - 1);
                } else {
                    dPoints--;
                }
            } else if (c == 'D') {
                if (rPoints <= 0) {
                    lastChar = 'D';
                    queue2.add(c);
                    dPoints++;
                    rPoints = Math.max(0, rPoints - 1);
                } else {
                    rPoints--;
                }
            }

            if (queue.isEmpty() && !allSame) {
                allSame = true;
                queue = queue2;
                queue2 = new LinkedList<Character>();
            }
        }

        return queue2.peek() == 'R' ? "Radiant" : "Dire";
    }
}