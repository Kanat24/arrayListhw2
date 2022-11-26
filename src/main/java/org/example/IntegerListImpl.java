package org.example;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private Integer[] array;
    private int size;

    public IntegerListImpl() {
        array = new Integer[10];
    }

    public IntegerListImpl(int storage) {
        array = new Integer[storage];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    public Integer[] getArray() {
        return array;

    }

    @Override
    public Integer add(Integer item) {
        validItem(item);
        validSize();
        array[size++] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
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
    public Integer set(int index, Integer item) {
        validIndex(index);
        validItem(item);
        array[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validItem(item);
        int index = indexOf(item);
        validIndex(index);
            return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validIndex(index);
        Integer item = array[index];
        validItem(item);
if (index!=size){
    System.arraycopy(array, index+1, array, index, size-index);
}
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        SortComparison.sortInsertion(array);
       if (containsBinary(array, item))
         {
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        validItem(item);
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(item, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
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

    public void validItem(Integer item) {
        if (item == null) {
            throw new ItemNotNullException();
        }
    }
    private boolean containsBinary(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}
