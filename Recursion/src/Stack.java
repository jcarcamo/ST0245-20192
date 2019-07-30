package eafit.edu.ds1.recursion;
import java.util.List;
import java.util.ArrayList;


public class Stack<E>{
    private int lastElementIndex;
    private List<E> list;

    public Stack() {
        list = new ArrayList<E>();
        lastElementIndex = 0;
    }

    public Stack(List<E> list) {
        this.list = list;
        lastElementIndex = this.list.size() - 1;
    }

    public E pop(){
        E p = list.get(lastElementIndex);
        list.remove(lastElementIndex);
        lastElementIndex = list.size() - 1;
        return p;
    }

    public void push(E p){
        list.add(p);
        lastElementIndex = list.size() - 1;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}
