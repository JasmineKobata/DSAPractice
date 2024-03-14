class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, startingIdx = 0;

        for (int i=0; i < gas.length; i++) {
            tank += gas[i];
            tank -= cost[i];
            if (tank < 0) {
                tank = 0;
                startingIdx = i+1;
                if (startingIdx == gas.length) return -1;
            }
        }

        for (int i=0; i < startingIdx; i++) {
            tank += gas[i];
            tank -= cost[i];
            if (tank < 0) return -1;
        }

        return startingIdx;
    }
}