import java.util.*;

class NegativeCycle{
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int vertices = in.nextInt();
        int edges = in.nextInt();
        WeightedGraph wGraph = new WeightedGraph(vertices);
        for(int i = 0; i < edges; i++){
            wGraph.addDirectedVertex(in.nextInt(), in.nextInt(), in.nextInt());
        }
        
        System.out.println(wGraph.hasNegativeCycle(0));
        in.close();
    }
}