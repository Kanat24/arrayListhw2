package org.example;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {
    private String[] array;
    private int size;

    public StringListImpl() {
        array = new String[10];
    }

    public StringListImpl(int storage) {
        array = new String[storage];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public String[] getArray() {
        return array;

    }

    @Override
    public String add(String item) {
        validItem(item);
        validSize();
        array[size++] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validItem(item);
        validSize();
        validIndex(index);
        if (index == size) {
            array[size++] = item;
            return item;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validIndex(index);
        validItem(item);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validItem(item);
        int index = indexOf(item);
        validIndex(index);
            return remove(index);
    }

    @Override
    public String remove(int index) {
        validIndex(index);
        String item = array[index];
        validItem(item);
if (index!=size){
    System.arraycopy(array, index+1, array, index, size-index);
}
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (indexOf(item) == -1) {
            return false;
        }
        return true;
    }

    @Override
    public int indexOf(String item) {
        validItem(item);
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Передан пустой список");
        }
        if (Arrays.equals(array, otherList.toArray())) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public void validSize() {
        if (size >= array.length) {
            throw new HighDimensionException();
        }
    }

    public void validIndex(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutException();
        }
    }

    public void validItem(String item) {
        if (item == null) {
            throw new ItemNotNullException();
        }
    }

}
