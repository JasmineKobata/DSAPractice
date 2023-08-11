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
            Set<String> visited = new HashSet<>();
            System.out.println("NEW QUERY");
            result[i++] = dfs(map, visited, q.get(0), q.get(1));
        }

        return result;
    }

    public double dfs(HashMap<String, HashMap<String, Double>> map, Set<String> vis, String currL, String lastL) {
        if (!map.containsKey(currL) || !map.containsKey(lastL)) {
            return -1.0;
        } else if (currL.equals(lastL)) {
            return 1.0;
        }

        double result = -1.0;

        for ( String key : map.get(currL).keySet() ) {
            if (!vis.contains(currL + key) && !vis.contains(key + currL)) {
                vis.add(currL + key);
                vis.add(key + currL);

                if ( key.equals(lastL) ) {
                    System.out.print("A ");
                    System.out.println(map.get(currL).get(lastL));
                    return map.get(currL).get(key);
                }
                double dfsNum = dfs(map, vis, key, lastL);
                if (dfsNum != -1.0) {
                    System.out.print("B " + dfsNum + " ");
                    System.out.println(map.get(currL).get(key));
                    if (result == -1.0) result = 1.0;
                    result *= map.get(currL).get(key);
                    result *= dfsNum;
                }
            }
        }

        return result;
    }
}