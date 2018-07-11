import java.util.*;
//checks for cycles in directed graphs
//input: int number of vertices, int number of edges
//, the same number of lines as number of edges, 
//each line consists of a source vertex and destination vertex
//output:  the number of cycles in the graph 
class Directed{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int edges = in.nextInt();
        Graph graph = new Graph(vertices);

        for(int i = 0; i < edges; i++){
            graph.addDirectedVertex(in.nextInt(), in.nextInt());
       }       
    
       System.out.println(graph.detectCycles());
       in.close();
    }
}