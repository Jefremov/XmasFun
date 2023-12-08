package com.accenture.internship;



import java.util.*;


public class ArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;


    public ArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayList(Object[] array, int size) {
        this.array = array;
        this.size = size;
    }

    public void add(T element) {

        if (size >= array.length) {
            Object[] newArray = new Object[size * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    @Override
    public void add(T element, int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", List size: " + size());
        }
        if (index == size()) {
            add(element);
        } else {
            if (size() == array.length) {
                Object[] newArray = new Object[size * 2];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }
            for (int i = size(); i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = element;
            size++;
        }
    }

    @Override
    public int size() {
        int count = 0;
        while (array[count] != null) {
            count++;
            if (count == size) {
                break;
            }
        }
        return count;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public int indexOf(T element) {
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    @Override
    public boolean hasNext(T element) {
        return indexOf(element) < size() - 1 && indexOf(element) >= 0;
    }


    @Override
    public T next(T element) {
        if (hasNext(element)) {
            return (T) array[indexOf(element) + 1];
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void remove(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();
        if (index != size()) {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
        }
        size--;
    }



    @Override
    public void remove(T element) {
        int index = indexOf(element);
        if(index >= 0){
            remove(index);
            remove(element);
        }
    }


    @Override
    public String toString() {
        return "MyArrayListImpl{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList that = (ArrayList) o;
        return size == that.size && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}

