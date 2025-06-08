package statistics;

import java.util.NoSuchElementException;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    public MyLinkedList() {
        this.top = null;
    }

    @Override
    public int size() {
        int count = 0;
        MyNode current = this.top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void add(double data) {
        MyNode newNode = new MyNode(data);
        if (this.top == null) {
            this.top = newNode;
        } else {
            MyNode current = this.top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = (newNode);
        }
    }

    @Override
    public void insert(double data, int index) {
        int currentSize = this.size();
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + currentSize);
        }
        MyNode newNode = new MyNode(data);
        if (index == 0) {
            newNode.next = (this.top);
            this.top = newNode;
        } else {
            MyNode previous = getNodeByIndex(index - 1);
            newNode.next = (previous.next);
            previous.next = (newNode);
        }
    }

    @Override
    public void remove(int index) {
        int currentSize = this.size();
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + currentSize);
        }
        if (index == 0) {
            this.top = this.top.next;
        } else {
            MyNode previous = getNodeByIndex(index - 1);
            previous.next = (previous.next.next);
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        MyLinkedList sortedList = new MyLinkedList();
        MyNode current = this.top;
        while (current != null) {
            sortedList.add(current.data);
            current = current.next;
        }

        if (sortedList.size() <= 1) {
            return sortedList;
        }

        boolean swapped;
        MyNode ptr1;
        MyNode lptr = null;

        if (sortedList.top == null) {
            return sortedList;
        }

        do {
            swapped = false;
            ptr1 = sortedList.top;
            while (ptr1.next != lptr) {
                if (ptr1.data > ptr1.next.data) {
                    double temp = ptr1.data;
                    ptr1.data = (ptr1.next.data);
                    ptr1.next.data = (temp);
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);

        return sortedList;
    }

    @Override
    public int binarySearch(double dataValue) {
        MyLinkedList sortedList = this.sortIncreasing();
        MyNode current = sortedList.top;
        int index = 0;
        while (current != null) {
            if (current.data == dataValue) {
                return index;
            }
            // Optimization: if current data is greater, and list is sorted, value not found
            if (current.data > dataValue) {
                return -1;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public MyIterator iterator(int start) {
        int currentSize = this.size();
        if (start < 0 || start > currentSize) { // Allow start == currentSize for iterator to be at end
            throw new IndexOutOfBoundsException("Start index: " + start + ", Size: " + currentSize);
        }
        return new MyLinkedListIterator(start);
    }

    public MyIterator iterator() {
        return new MyLinkedListIterator(0);
    }

    private MyNode getNodeByIndex(int index) {
        // This method assumes index is valid, or relies on caller to validate
        // based on dynamic size. For internal use, ensure index < currentSize.
        int currentSize = this.size();
        if (index < 0 || index >= currentSize) { // Re-check for safety, though internal calls should be careful
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + currentSize);
        }
        MyNode current = this.top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition; // Vị trí của phần tử *tiếp theo* sẽ được trả về bởi next()

        public MyLinkedListIterator(int startPosition) {
            this.currentPosition = startPosition;
        }

        @Override
        public boolean hasNext() {
            return this.currentPosition < MyLinkedList.this.size();
        }

        @Override
        public Number next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            MyNode nodeToReturn = MyLinkedList.this.getNodeByIndex(this.currentPosition);
            this.currentPosition++;
            return nodeToReturn.data;
        }

        @Override
        public void remove() {
            // currentPosition hiện tại đang trỏ đến phần tử *sau* phần tử vừa được trả về bởi next().
            // Do đó, phần tử cần xóa là ở vị trí (currentPosition - 1).
            // Logic này tương tự như remove(--currentPosition) trong một số cài đặt iterator đơn giản.
            if (this.currentPosition == 0) {
                // Không thể gọi remove nếu next() chưa được gọi để currentPosition > 0,
                // hoặc nếu iterator đang ở đầu danh sách và chưa có phần tử nào được trả về.
                throw new IllegalStateException("next() must be called to advance the iterator before remove() can be called.");
            }
            // Giảm currentPosition để nó trỏ đến phần tử vừa được trả về bởi next()
            this.currentPosition--;
            // Xóa phần tử tại vị trí currentPosition mới này
            MyLinkedList.this.remove(this.currentPosition);
            // Sau khi xóa, danh sách co lại. Phần tử mà ban đầu ở vị trí (currentPosition + 1 cũ)
            // bây giờ nằm ở vị trí currentPosition (mới). Con trỏ currentPosition đã đúng vị trí
            // cho lần gọi next() tiếp theo.
        }
    }
}
