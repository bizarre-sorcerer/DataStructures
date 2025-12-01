package datastructures.collections.stack;

import datastructures.collections.AbstractCollection;

import java.util.EmptyStackException;

public class MyStack<E> extends AbstractCollection<E> {

    public synchronized void push(E obj) {
        add(obj);
    }

    public synchronized void pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        removeLast();
    }

    public synchronized E peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }

        return get(size()-1);
    }
}
