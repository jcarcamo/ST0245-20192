public class Graph<DATA> {
    private final int MAX_VERT = 20;
    private Vertex<DATA> V[];
    private int adj[][];

    private ArrayStack<Integer> stack;

    private int nVerts;

    private int findNextNeighbor(int vertexId){

        for(int col = 0; col < nVerts; col++){
            if(adj[vertexId][col] == 1 &&
                !V[col].isVisited()){
                return col;
            }
        }
        return -1;
    }
    public Graph() {
        V = new Vertex[MAX_VERT];
        adj = new int[MAX_VERT][MAX_VERT];
        nVerts = 0;
    }

    public void addVertex(Vertex v){
        V[nVerts] = v;
        nVerts++;
    }
    public void addEdge(int start, int end){
        adj[start][end] = 1;
        adj[end][start] = 1;
    }

    public int DFS(){
        int count = 0;
        stack = new ArrayStack<>();
        int v = 0;
        stack.push(v);
        V[v].setVisited(true);
        System.out.println("Starting PATH");
        System.out.print(V[v].getData() + " - ");
        while(!stack.isEmpty()){
            v = findNextNeighbor(stack.peek());
            if(v == -1){
                stack.pop();
            }else{

                V[v].setVisited(true);
                System.out.print(V[v].getData() + " - ");
                stack.push(v);
                count++;
            }
        }
        System.out.println();
        for(int i = 0; i < nVerts; i++){
            V[i].setVisited(false);
        }

        return count;
    }

}
