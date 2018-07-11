import java.util.*;

class Graph{
    private ArrayList<ArrayList<Integer>> adjMatrix;
    private Boolean[] visited;

    public Graph(int n){
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

    public ArrayList<ArrayList<Integer>> getAdjMatrix(){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < adjMatrix.size(); i++){
            temp = adjMatrix.get(i);
            for(int j = 0 ; j < temp.size(); j++){
                System.out.println(temp.get(j));
            }
        }
        return adjMatrix;
    }

    public void addUndirectedVertex(int src, int dest){
        ArrayList<Integer> temp = adjMatrix.get(src-1);
        temp.set(dest-1, 1);
        temp = adjMatrix.get(dest - 1);
        temp.set(src-1, 1);
    }

    public void addDirectedVertex(int src, int dest){
        ArrayList<Integer> temp = adjMatrix.get(src-1);
        temp.set(dest-1, 1);
    }

    public int detectCycles(){
        int cycleCount = 0;
      
        for(int i = 0 ; i < visited.length; i++){
            if(!visited[i])
                if(DFSCycle(i) == i){
                    cycleCount++;
                }    
            }
        resetVisited();
        return cycleCount;
    }

    private int DFSCycle(int v){

        visited[v] = true;

        ArrayList<Integer> temp = adjMatrix.get(v);
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) == 1){
                if(!visited[i]){
                    DFSCycle(i);
                }else{
                    return i;
                }
            }    
        }
    
        return v;
    }

    public void DFS(int v){
        visited[v] = true;
        ArrayList<Integer> temp = adjMatrix.get(v);
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) == 1){
                if(!visited[i]){
                    DFS(i);
                }
            }    
        }
    }
    
    public Boolean checkVisited(){
        for(int i = 0; i < visited.length; i++)
            if(!visited[i])
                return false;
        return true;
    }

    public int followMaze(int j){
        DFS(j);
        if(checkVisited()){
           
            return 1;
        }
        return 0;
    }

    public int followMaze(int src, int dest){
        DFS(src-1);
        if(visited[dest-1] == true){
            
            return 1;
        }
        
        return 0;
    }

    public int getNumberOfComponents(){
        int componentCount = 0;
        for(int j = 0; j < visited.length; j++){
            if(checkVisited())
                break;
            if(visited[j] == false){
                DFS(j);
                componentCount++;
            }          
        }
        return componentCount;
    }

    public void resetVisited(){
        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
    }

    public Boolean isBipartite(){
        int [] color = new int[adjMatrix.size()];
        Arrays.fill(color, -1);
        int u;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        color[0] = 1;
        queue.add(0);

        while(!queue.isEmpty()){
            u = queue.poll();
            arr = adjMatrix.get(u);
            if(arr.get(u) == 1)
                return false;
            for(int i = 0 ; i < arr.size(); i++){
                if(arr.get(i) == 1 && color[i] == -1){
                    queue.add(i);
                    color[i] = 1 - color[u];
                }
                else if(arr.get(i) == 1 && color[i] == color[u]){
                    return false;
                }
            }
        }

        return true;
    }
    
    public ArrayList<Integer> BFS(int A, int B){
        int[] prev = new int[adjMatrix.size()];
        int[] dist = new int[adjMatrix.size()];
        int u;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < adjMatrix.size(); i++){
            dist[i] = Integer.MAX_VALUE;
            prev[i] = 0;
        }

        dist[A] = 0;
        queue.add(A);
        
        while(!queue.isEmpty()){
            u = queue.poll();
            arr = adjMatrix.get(u);
            for(int k = 0; k < arr.size(); k++){
                if(arr.get(k) == 1){
                    if(dist[k] == Integer.MAX_VALUE){
                        queue.add(k);
                        dist[k] = dist[u] + 1;
                        prev[k] = u;
                    }
                }
            }
        }
      
        if(dist[B]  == Integer.MAX_VALUE){
            return new ArrayList<>();
        }
        
        return reconstructPath(A, B, prev);
    }

    private ArrayList<Integer> reconstructPath(int A, int u, int[] prev){
        ArrayList<Integer> result = new ArrayList<Integer>();
   
        while(u != A){
            result.add(u);
            u = prev[u];
        }

        for(int i = 0 ; i < result.size() / 2; i++){
            int temp = result.get(i);
            result.set(i, result.get(result.size() - i - 1));
            result.set(result.get(result.size() - i - 1), temp);
        }

        return result;
    }
}