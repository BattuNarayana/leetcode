class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Build adjacency list
        // Each entry: {nextCity, price}
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Min-heap based on cost
        // State: {cost, currentCity, flightsUsed}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // k = maximum number of stops
        // Therefore, maximum number of flights = k + 1
        int maxFlights = k + 1;

        /*
         * dist[city][flightsUsed] =
         * minimum cost required to reach 'city'
         * using exactly 'flightsUsed' flights.
         *
         * We keep flightsUsed as part of the state because
         * reaching the same city with different numbers of
         * flights can lead to different possibilities.
         */
        int[][] dist = new int[n][maxFlights + 1];

        for (int[] row : dist) {
            Arrays.fill(row, (int) 1e9);
        }

        // Cost to reach src using 0 flights is 0
        dist[src][0] = 0;

        // {cost, currentCity, flightsUsed}
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currCost = curr[0];
            int currCity = curr[1];
            int flightsUsed = curr[2];

            // Since PQ gives the minimum-cost state first,
            // the first valid time we reach dst is the answer.
            if (currCity == dst) {
                return currCost;
            }

            // Cannot take more flights than k + 1
            if (flightsUsed >= maxFlights) {
                continue;
            }

            // Explore all flights from the current city
            for (int[] ngh : adj.get(currCity)) {

                int nextCity = ngh[0];
                int price = ngh[1];

                int newCost = currCost + price;
                int newFlights = flightsUsed + 1;

                // Only consider this state if it gives a cheaper
                // cost for this particular city and flight count.
                if (newCost < dist[nextCity][newFlights]) {

                    dist[nextCity][newFlights] = newCost;

                    pq.offer(new int[]{newCost, nextCity, newFlights});
                }
            }
        }

        return -1;
    }
}