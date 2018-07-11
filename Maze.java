import java.util.Scanner;

//check if two vertices are connected
//input: int vertices, int edges, 
//same number of lines as the value of edges with each line
// having src vertex and dest vertex
// final line contains the src and dest vertex to be checked
//output: 0 if vertices arent connected, and 1 if they are connected 

class Maze{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int edges = in.nextInt();
        Graph graph = new Graph(vertices);

        for(int i = 0; i < edges; i++){
            graph.addUndirectedVertex(in.nextInt(), in.nextInt());
       }       
       graph.printAdjMatrix();
       System.out.println(graph.followMaze(in.nextInt(), in.nextInt()));
       graph.resetVisited();
       System.out.println("Component Count: " + graph.getNumberOfComponents());
       graph.resetVisited();
    }
}