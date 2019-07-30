package eafit.edu.ds1.recursion;
public class Position {
    private int x;
    private int y;

    private Position prev;

    public Position(){
        this.x = 0;
        this.y = 0;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getPrev() {
        return prev;
    }

    public void setPrev(Position prev) {
        this.prev = prev;
    }
}
