import java.util.*;

public class network-delay-time {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] weights = new int[N+1];
        int max_val = Integer.MAX_VALUE;
        Arrays.fill(weights, max_val);
        weights[K]=0;
        for(int i=0;i<N;i++) {
            for(int[] edge: times) {
                int currentWeight = weights[edge[1]];
                int relaxedWeight = (weights[edge[0]] == max_val)?max_val:weights[edge[0]]+edge[2];
                weights[edge[1]] = Math.min(currentWeight, relaxedWeight);
            }
        }
        int maxWeight = -1;
        for(int i=1;i<=N;i++) {
            if(maxWeight<weights[i]) {
                maxWeight = weights[i];
            }
        }
        return (maxWeight==Integer.MAX_VALUE)?-1:maxWeight;
        
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
