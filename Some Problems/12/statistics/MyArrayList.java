package statistics;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    public MyArrayList() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(double value) {
        if (size >= data.length) {
            allocateMore();
        }
        data[size++] = value;
    }

    @Override
    public void insert(double value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size >= data.length) {
            allocateMore();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        MyArrayList sortedList = new MyArrayList();
        for (int i = 0; i < this.size; i++) {
            sortedList.add(this.data[i]);
        }
        Arrays.sort(sortedList.data, 0, sortedList.size);
        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        MyArrayList sortedList = this.sortIncreasing();
        int left = 0;
        int right = sortedList.size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedList.data[mid] == data) {
                return mid;
            }
            if (sortedList.data[mid] < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public MyIterator iterator(int start) {
        if (start < 0 || start > size) {
            throw new IndexOutOfBoundsException("Start index out of bounds");
        }
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        int newCapacity = data.length * 2;
        if (newCapacity == 0) {
            newCapacity = DEFAULT_CAPACITY;
        }
        this.data = Arrays.copyOf(this.data, newCapacity);
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;
        private int lastRet = -1;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < MyArrayList.this.size;
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastRet = currentPosition;
            return MyArrayList.this.data[currentPosition++];
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(lastRet);
            currentPosition = lastRet;
            lastRet = -1;
        }
    }
}
