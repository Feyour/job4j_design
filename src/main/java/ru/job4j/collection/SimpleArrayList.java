package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;
    private int size;
    private int modCount;

    public SimpleArrayList(int capacity) {
        container = (T[]) new Object[capacity];
    }

    public void arrSize() {
        container = Arrays.copyOf(container, container.length == 0 ? 1 : container.length * 2);
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            arrSize();
        }
        container[size] = value;
        size++;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        try {
            Objects.checkIndex(index, size);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
        T value = container[index];
        container[index] = newValue;
        return value;
    }

    @Override
    public T remove(int index) {
        try {
            Objects.checkIndex(index, size);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
        T value = container[index];
        System.arraycopy(container, index + 1, container, index, size - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return value;
    }

    @Override
    public T get(int index) {
        try {
            Objects.checkIndex(index, size);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
        return container[index];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return container[currentIndex++];
            }
        };
    }
}