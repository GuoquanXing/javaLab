package com.example.lab.demo.datastructure.stack;

public class ArrayStack<E> {

    private static final int CAPACITY = 100;
    private int topIndex = -1;
    private E[] data;

    public ArrayStack(){
        this(CAPACITY);
    }
    public ArrayStack(int capacity){
        this.data = (E[]) new Object[capacity];
        topIndex++;
    }

    public int size(){
        return topIndex;
    }

    public boolean isEmpty(){
        return topIndex == 0;
    }

    public E peek(){
        if(topIndex == 0) throw new RuntimeException("Stack is empty");
        return data[topIndex];
    }

    public void push(E e){
        if(topIndex == ArrayStack.CAPACITY) throw new RuntimeException("stack is full");
        data[++topIndex] = e;
    }

    public E pop(){
        if(topIndex == 0) throw new RuntimeException("Stack is empty");
        E value = data[topIndex];
        data[topIndex] = null;
        topIndex--;
        return value;
    }
}
