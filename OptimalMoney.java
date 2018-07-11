import java.util.Scanner;

class OptimalMoney{
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int edges = in.nextInt();
        int startNode;
        WeightedGraph wGraph = new WeightedGraph(vertices);
        for(int i = 0; i < edges; i++){
            wGraph.addDirectedVertex(in.nextInt(), in.nextInt(), in.nextInt());
        }
        
        startNode = in.nextInt() - 1;

        for(int i = 0; i < vertices; i++)
            wGraph.hasNegativeCycle(startNode, i);
        in.close();
    }
}