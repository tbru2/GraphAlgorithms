import java.util.*;

//calculate the min distance between two nodes using Dijkstra's Algorithm
//input:  int vertices, int edges, 
//same number of lines as the value of edges with each line
// having src vertex, dest vertex, and weight
// final line contains the src and dest vertex to be checked
//output: print -1 if vertices arent connected or print the minimum distance 

class FlightCost{
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int edges = in.nextInt();
        WeightedGraph wGraph = new WeightedGraph(vertices);
        for(int i = 0; i < edges; i++){
            wGraph.addDirectedVertex(in.nextInt(), in.nextInt(), in.nextInt());
        }
               
        System.out.println(wGraph.Dijkstra(in.nextInt()-1, in.nextInt()-1));
        in.close();
    }
}