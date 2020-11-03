import java.util.*;

class MinCostToConnect {
    public int minCostConnectPoints(int[][] points) {
        if(points.length==1) {
            return 0;
        }
        Map<Point, List<Point>> graph = new HashMap<>();
        for(int i=0;i<points.length;i++) {
            Point src = new Point(points[i][0], points[i][1]);
            for (int j=0;j<points.length;j++) {
                if(i != j)                {
                    Point dest = new Point(points[j][0], points[j][1]);
                    List<Point> neighbours = graph.get(src);
                    if(null == neighbours) {
                        neighbours = new ArrayList<Point>();
                    }
                    neighbours.add(dest);
                    graph.put(src, neighbours);
                }
            }
        }
        
        return getMinCost(graph, new Point(points[0][0], points[0][1]), points.length);
        
    }
    
    public int getMinCost(Map<Point, List<Point>> graph, Point point, int N) {
        int solution = 0;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x,y) -> x[2].compareTo(y[2]));
        pq.add(new Integer[] {point.x, point.y, 0});
        Set<Point> visited =  new HashSet<>();
        while(visited.size() < N) {
            Integer[] arr = pq.remove();
            Point newSource = new Point(arr[0], arr[1]);
            if(!visited.contains(newSource)) {
                int newWeight = arr[2];
                visited.add(newSource);
                solution += newWeight;
                List<Point> neighbours = graph.get(newSource);
                for(Point p: neighbours) {
                    if(!visited.contains(p)) {
                        pq.add(new Integer[] {p.x, p.y, Math.abs(p.x-newSource.x)+Math.abs(p.y-newSource.y)});
                    }
                }
            }
            
        }
        return solution;
    }
    
    class Point {
        Integer x;
        Integer y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return this.x.equals(p.x) && this.y.equals(p.y);
        }
        public int hashCode() {
            return x.hashCode()+y.hashCode();
        }
        public String toString() {
            return "x:"+x+" y:"+y;
        }
    }
}
