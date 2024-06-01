package hus.oop.mybookmanager;

public class MyLinkedList extends AbstractMyList {
    private Node head;
    private int size;

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;

        public MyLinkedListIterator(int start) {
            /* TODO */
            if (checkBoundaries(start, size() - 1)) {
                currentPosition = start;
                return;
            }
            currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;
        }

        @Override
        public Object next() {
            /* TODO */
            if (hasNext()) {
                return getNodeByIndex(currentPosition++).data;
            }
            return null;
        }
    }

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        /* TODO */
        head = new Node(null);
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(Object data, int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        getNodeByIndex(index).data = data;
    }

    @Override
    public Object get(int index) {
        return getNodeByIndex(index).data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(Object value) {
        /* TODO */
        if (size == 0) {
            head = new Node(value);
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(Object value) {
        /* TODO */
        if (size == 0) {
            head = new Node(value);
        } else {
            Node current = getNodeByIndex(size - 1);
            current.next = new Node(value);
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPosition(Object value, int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertAtStart(value);
            return;
        }
        if (index == size - 1) {
            insertAtEnd(value);
            return;
        }
        Node current = getNodeByIndex(index - 1);
        Node newNode = new Node(value);
        newNode.next = current.next.next;
        current.next = newNode;
        size++;
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
        } else if (index == size() - 1) {
            Node current = getNodeByIndex(index - 1);
            current.next = null;
            size--;
        } else {
            Node current = getNodeByIndex(index - 1);
            current.next = current.next.next;
        }
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        if (!checkBoundaries(index, size - 1)) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(0);
    }
}
