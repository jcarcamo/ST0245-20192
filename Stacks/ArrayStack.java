package edu.eafit.st0245.stacks;

public class ArrayStack<E> {

    private int size;
    private E[] array;
    private int top;

    public ArrayStack(int size) {
        this.size = size;
        this.top = -1;
        if(size > 0) {
            this.array = (E[]) new Object[size];
        }else{
            this.array = (E[]) new Object[20];
        }
    }

    private void doubleArraySize(){
        E[] newArray = (E[]) new Object[this.size*2];
        for(int i = 0; i < this.array.length; i++){
            newArray[i] = this.array[i];
        }
        this.size = this.size*2;
        this.array = newArray;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(E element){
        top++;
        if(top == size){
            this.doubleArraySize();
        }
        this.array[top] = element;
    }

    public E pop(){
        if(this.isEmpty()){
            return null;
        }
        return this.array[top--];
    }

    public E peek(){
        if(this.isEmpty()){
            return null;
        }
        return this.array[top];
    }
}
