package com.github.pioneeryi;

public class Stack<T> {
    private static final int DEFAULT_CAPACITY = 3;


    private int size;
    private int capacity;

    private Object[] elements;

    public Stack() {
        capacity = DEFAULT_CAPACITY;
        elements = new Object[capacity];
    }

    public void push(int item) {
        if (size >= capacity) {
            capacity = 2 * capacity;
            Object[] temp = new Object[capacity];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = item;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("not element");
        }
        return (T) elements[--size];
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

}
