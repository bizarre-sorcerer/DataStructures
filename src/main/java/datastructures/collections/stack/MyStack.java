package datastructures.collections.stack;

import java.util.EmptyStackException;

public class MyStack<E> {

    private Object[] elementData;

    private static final Object[] DEFAULT_EMPTY_ELEMENTS = {};

    private static final int defaultCapacity = 10;

    private int size;

    public MyStack() {
        this(defaultCapacity);
    }

    public MyStack(int capacity) {
        if  (capacity > 0) {
            elementData = new Object[capacity];
        } else if (capacity == 0) {
            elementData = DEFAULT_EMPTY_ELEMENTS;
        } else {
            throw new IllegalArgumentException(String.format("Illegal capacity: %s", capacity));
        }
    }

    public int size() {
        return size;
    }

    public synchronized void push(E obj) {
        if  (size == elementData.length) {
            grow();
        }
        elementData[size++] = obj;
    }

    public synchronized E pop() {
        if  (size == 0) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        E value = (E) elementData[--size];
        elementData[size] = null;

        return value;
    }

    public synchronized E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked")
        E value = (E) elementData[size-1];
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        Object[] newElements = new Object[elementData.length * 2];
        System.arraycopy(elementData, 0, newElements, 0, elementData.length);
        elementData = newElements;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(elementData[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
