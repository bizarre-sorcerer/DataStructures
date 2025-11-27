package datastructures.list.impl;

import datastructures.list.MyList;

import java.util.AbstractList;

public class MyArrayList<E> extends AbstractList<E>
                            implements MyList<E> {

    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public Object[] elements;

    public static final Object[] DEFAULT_EMPTY_ELEMENTS = {};

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elements = DEFAULT_EMPTY_ELEMENTS;
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + initialCapacity);
        }
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean add(E e){
        if (elements == DEFAULT_EMPTY_ELEMENTS || size == elements.length) {
            grow();
        }
        elements[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E e){
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        if (elements == DEFAULT_EMPTY_ELEMENTS || size == elements.length) {
            grow();
        }
        Object[] newElements = new Object[size+1];

        for (int i = 0; i < size+1; i++){
            if  (i < index) {
                newElements[i] = elements[i];
            } else if  (i == index){
                newElements[i] = e;
            } else {
                newElements[i] = elements[i-1];
            }
        }
        size++;
        elements = newElements;
    }

    private Object[] grow(){
        Object[] newElements = new Object[elements.length*2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
        return newElements;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return (E) elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
