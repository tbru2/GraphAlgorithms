import java.util.*;

class WeightedGraph{
    private ArrayList<ArrayList<Integer>> adjMatrix;
    private Boolean[] visited;

    public WeightedGraph(int n){
        adjMatrix = new ArrayList<ArrayList<Integer>>();
        visited = new Boolean[n];
        for(int i = 0; i < n ; i++){
            visited[i] = false;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                temp.add(0);
            }
            adjMatrix.add(temp);
        }
    }

    public void printAdjMatrix(){
        for(int i = 0; i < adjMatrix.size(); i++){
            ArrayList<Integer> temp = adjMatrix.get(i);
            for(int j = 0 ; j< temp.size(); j++){
                System.out.print(temp.get(j) + " ");
            }
            System.out.println();
        }
    }

    public void addDirectedVertex(int src, int dest, int weight){
        ArrayList<Integer> temp = adjMatrix.get(src-1);
        temp.set(dest-1, weight);
    }

    public int Dijkstra(int A, int B){
        int[] dist = new int[adjMatrix.size()];
        int[] prev = new int[adjMatrix.size()];
        int u;
        PriorityQueue<Map.Entry<Integer, Integer>> queue = 
                new PriorityQueue<Map.Entry<Integer, Integer>>
                    (new Comparator<Map.Entry<Integer, Integer>>(){
                            @Override
                            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
                                return a.getValue() - b.getValue();
                            }
                    });
        
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < adjMatrix.size(); i++){
            dist[i] = Integer.MAX_VALUE;
            prev[i] = 0;
        }
        
        dist[A] = 0;
        queue.add(new AbstractMap.SimpleEntry<Integer, Integer>(A, dist[A]));
        
        while(!queue.isEmpty()){
            u = queue.poll().getKey();
            arr = adjMatrix.get(u);
            for(int k = 0; k < arr.size(); k++){
                if(dist[k] > dist[u] + arr.get(k) && arr.get(k) != 0){
                    dist[k] = dist[u] + arr.get(k);
                    prev[k] = u;
                    queue.add(
                        new AbstractMap.SimpleEntry<Integer, Integer>(k, dist[k]));
                }
            }
        }

        if(dist[B]  == Integer.MAX_VALUE){
            return -1;
        }

        return dist[B];
    }

    public Boolean hasNegativeCycle(int s){
        int[] dist = new int[adjMatrix.size()];
        int[] prev = new int[adjMatrix.size()];
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i = 0; i < adjMatrix.size(); i++){
            dist[i] = Integer.MAX_VALUE;
            prev[i] = 0;
        }

        dist[s] = 0;
        
        for(int j = 0; j < adjMatrix.size() - 1; j++){
            for(int f = 0; f < adjMatrix.size(); f++){
                arr = adjMatrix.get(f);
                for(int k = 0; k < arr.size(); k++){
                    if(dist[k] > dist[f] + arr.get(k) && arr.get(k) !=0){
                        dist[k] = dist[f] + arr.get(k);
                        prev[k] = f;
                    }  
                }
            }
        }
        
        for(int f = 0; f < adjMatrix.size(); f++){
            arr = adjMatrix.get(f);
            for(int k = 0; k < arr.size(); k++){
                if(dist[k] > dist[f] + arr.get(k) && dist[k] != Integer.MAX_VALUE){
                    return true;
                }  
            }
        }

        return false;
    }

    public void hasNegativeCycle(int s, int dest){

        if(s == dest){
            System.out.println(0);
            return;
        }    
        
        int[] dist = new int[adjMatrix.size()];
        int[] prev = new int[adjMatrix.size()];
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int distance = 0;

        for(int i = 0; i < adjMatrix.size(); i++){
            dist[i] = Integer.MAX_VALUE;
            prev[i] = 0;
        }

        dist[s] = 0;
        distance = dist[dest];

        for(int j = 0; j <= adjMatrix.size()-1; j++){
            for(int f = 0; f < adjMatrix.size(); f++){
                arr = adjMatrix.get(f);
                for(int k = 0; k < arr.size(); k++){
                    if(dist[k] > dist[f] + arr.get(k) && arr.get(k) !=0){
                        dist[k] = dist[f] + arr.get(k);
                        prev[k] = f;
                        if(k == dest){
                            if(distance > dist[dest] && distance != Integer.MAX_VALUE){
                                System.out.println("-");
                                return;
                            }
                            distance = dist[dest];
                        }
                    }       
                }
            }
        }
       
       if(dist[dest] <= 0){
           System.out.println("-");
           return;
        }

        if(dist[dest] == Integer.MAX_VALUE){
            System.out.println("*");
            return;
        }
      
        for(int j = 0; j < adjMatrix.size(); j++){
            arr = adjMatrix.get(j);
            if(dist[dest] > dist[dest] + arr.get(dest) && dist[dest] != Integer.MAX_VALUE){
                System.out.println("-");
                return; 
            }
        }
        
        System.out.println(dist[dest]);
        return;
    }
}


