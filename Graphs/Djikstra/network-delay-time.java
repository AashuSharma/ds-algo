import java.util.*;

public class network-delay-time {
    public int networkDelayTime(int[][] times, int N, int K) {
        int sol = -1;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(N,(a,b) -> a.w.compareTo(b.w));
        pq.add(new Pair(K,0));
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            if(!visited.contains(pair.n)) {
                visited.add(pair.n);
                for(int[] y: times) {
                    if((y[0] == pair.n) && !visited.contains(y[1])) {
                        pq.add(new Pair(y[1], y[2]+pair.w));
                    }
                }
                if(pair.w>sol) {
                    sol=pair.w;
                } 
            }
            
        }
        if(visited.size() != N) {
            sol = -1;
        }
        return sol;
        
    }
    
    class Pair{
        Integer n;
        Integer w;
        Pair(int n, int w) {
            this.n=n;
            this.w=w;
        }
    }
}
