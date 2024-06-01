package hus.oop.basicstatistics;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 8;
    private Number[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        /* TODO */
    }

    /**
     * Lấy kích thước của list.
     * @return
     */
    @Override
    public int size() {
        /* TODO */
    }

    /**
     * Lấy phần tử ở vị trí index trong list.
     * @param index
     * @return
     */
    @Override
    public Number get(int index) {
        /* TODO */
    }

    /**
     * Xóa phần tử ở vị trí index trong list.
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
    }

    /**
     * Thêm phần tử có dữ liệu payload vào cuối list.
     * Nếu danh sách hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     */
    @Override
    public void append(Number payload) {
        /* TODO */
    }

    /**
     * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
     * Nếu list hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
     * @param payload
     * @param index
     */
    @Override
    public void insert(Number payload, int index) {
        /* TODO */
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     * @return
     */
    @Override
    public MyIterator iterator() {
        /* TODO */
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void enlarge() {
        /* TODO */
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            /* TODO */
        }

        /**
         * Kiểm tra trong MyArrayList có còn phần tử không.
         * Nếu còn thì trả về true, nếu không còn thì trả về false.
         * @return
         */
        @Override
        public boolean hasNext() {
            /* TODO */
        }

        /**
         * iterator dịch chuyển sang phần tử kế tiếp của MyArrayList và trả ra dữ liệu của phần tử hiện tại của MyArrayList.
         * @return dữ liệu phần tử hiện tại.
         */
        @Override
        public Number next() {
            /* TODO */
        }

        /**
         * Iterator xóa phần tử hiện tại của MyArrayList.
         */
        @Override
        public void remove() {
            /* TODO */
        }
    }
}
