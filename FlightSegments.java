import java.util.Scanner;
import java.util.ArrayList;

//calculate the minimum distance between two nodes
//input:  int vertices, int edges, 
//same number of lines as the value of edges with each line
// having src vertex and dest vertex
// final line contains the src and dest vertex to be checked
//output: print -1 if vertices arent connected or print the minimum distance 

class FlightSegments{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int edges = in.nextInt();
        Graph graph = new Graph(vertices);
        ArrayList<Integer> path = new ArrayList<>();
        for(int i = 0; i < edges; i++){
            graph.addUndirectedVertex(in.nextInt(), in.nextInt());
       }       

    //   path = graph.BFS(in.nextInt()-1, in.nextInt()-1);
  //     if(path.size() == 0)
  //          System.out.println(-1);
  //      else
   //         System.out.println(path.size());

        System.out.println(graph.isBipartite());
    }
}