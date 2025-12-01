package datastructures.collections;

public class AbstractCollection<E>{

    private Object[] elementData;

    private int size;

    private static final int defaultCapacity = 10;

    private static final Object[] DEFAULT_EMPTY_ELEMENTS = {};

    public AbstractCollection() {
        this(defaultCapacity);
    }

    public AbstractCollection(int capacity) {
        if  (capacity > 0) {
            elementData = new Object[capacity];
        } else if (capacity == 0) {
            elementData = DEFAULT_EMPTY_ELEMENTS;
        } else {
            throw new IllegalArgumentException(String.format("Illegal capacity: %s", capacity));
        }
    }

    public boolean add(E e){
        if (elementData == DEFAULT_EMPTY_ELEMENTS || size == elementData.length) {
            grow();
        }
        elementData[size++] = e;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Index: %d, Size: %d", index, size));
        }

        @SuppressWarnings("unchecked")
        E element = (E) elementData[index];
        return element;
    }

    public void removeLast() {
        elementData[--size] = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = (oldCapacity == 0) ? defaultCapacity : oldCapacity * 2;
        Object[] newElements = new Object[newCapacity];
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
