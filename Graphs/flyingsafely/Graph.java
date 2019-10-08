import java.util.*;

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

    HashMap<Vertex,Vertex> parent  = new HashMap<>();

    public int BFS(){
        int count = 0;
        Vertex s = V[0];
        s.setVisited(true);
        parent.put(s, null);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int currentIdx = queue.remove();
            int idx = findNextNeighbor(currentIdx);
            while(idx != -1){
                V[idx].setVisited(true);
                queue.add(idx);
                count++;
                idx = findNextNeighbor(currentIdx);
                parent.put(V[idx], V[currentIdx]);
            }
        }

        return count;
    }


    public int RecursiveDFS(){
        int count = 0;
        for(int i = 0; i < nVerts; i++){
            Vertex v = V[i];
            if(!v.isVisited())
                v.setVisited(true);
            count += RecursiveDFSVisit(i);
        }
        for(int i=0; i < nVerts; i++){
            Vertex v = V[i];
            v.setVisited(false);
        }
        return count;
    }

    public int RecursiveDFSVisit(int vIdx){
        int count = 0;
        int idx = findNextNeighbor(vIdx);
        while(idx  != -1){
            Vertex u = V[idx];
            if(!u.isVisited()) {
                u.setVisited(true);
                count = 1 + RecursiveDFSVisit(idx);
            }
            idx = findNextNeighbor(vIdx);
        }
        return count;
    }

}
