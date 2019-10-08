public class ArrayStack<DATA> {
    private final int SIZE = 25;
    private DATA[] st;
    private int top;

    public ArrayStack(){
        st = (DATA[]) new Object[SIZE]; // make array
        top = -1;
    }
    public void push(DATA j){ // put item on stack
        st[++top] = j;
    }

    public DATA pop(){  // take item off stack
        return st[top--];
    }

    public DATA peek(){ // peek at top of stack
        return st[top];
    }

    public boolean isEmpty(){ // true if nothing on stack
        return (top == -1);
    }
}