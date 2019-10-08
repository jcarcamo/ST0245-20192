public class Vertex<DATA>{
    private DATA data;
    private boolean visited = false;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex() {
    }

    public Vertex(DATA data) {
        this.data = data;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }
}
