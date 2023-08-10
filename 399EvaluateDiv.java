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
            if (!map.containsKey(q.get(0)) || !map.containsKey(q.get(1))) {
                result[i++] = -1.0;
            } else {
                result[i++] = dfs(map, q, q); //recursively find multiplication path                
            }
        }

        return result;
    }

    public double dfs(HashMap<String, HashMap<String, Double>> map, List<String> q, List<String> iter) {
        double result = 0;
        System.out.println(q);
        // map.get(iter.get(0)).forEach( (k, v) -> {
        //     //add v to result if first # found or both #s found
        //     // result += dfs(map, q, new List<>(''))
        // });

        for ( String key : map.get(iter.get(0)).keySet() ) {
            System.out.println(key);
            if ( key == q.get(1) ) {
                System.out.println(map.get(key).get(iter.get(1)));
            }
            // System.out.println(key);
        }

        return result;
    }
}