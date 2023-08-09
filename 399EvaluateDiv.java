class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        double[] result = new double[queries.size()];

        for (int i=0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            if (!map.containsKey(eq.get(0))) map.put(eq.get(0), new HashMap<String, Double>());
            if (!map.containsKey(eq.get(1))) map.put(eq.get(1), new HashMap<String, Double>());

            map.get(eq.get(0)).put(eq.get(1), values[i]);
            map.get(eq.get(1)).put(eq.get(0), 1.0 / values[i]);
        }
        System.out.println(map);

        int i = 0;
        for (List<String> q : queries) {
            System.out.println(i);
            if (!map.containsKey(q.get(0)) || !map.containsKey(q.get(1))) {
                result[i++] = -1.0;
            } else {
                result[i++] = dfs(map, q); //recursively find multiplication path                
            }
        }

        return result;
    }

    public double dfs(HashMap<String, HashMap<String, Double>> map, List<String> q) {
        map.get(q.get(0)).forEach( (k, v) -> {
            System.out.println(k);
        });
        return 0;
    }
}