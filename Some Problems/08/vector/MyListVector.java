package hus.oop.vector;

import java.util.List;

public class MyListVector extends AbstractMyVector {
    private List<Double> data;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyListVector() {
        /* TODO */
    }

    @Override
    public int size() {
        /* TODO */
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
    }

    @Override
    public double[] coordinates() {
        /* TODO */
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
    }

    /**
     * Cộng các phần tử của vector với value.
     * @param value
     * @return vector mới.
     */
    public MyListVector add(double value) {
        /* TODO */
    }

    /**
     * Cộng vector hiện tại với một vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector mới.
     */
    public MyListVector add(MyVector another) {
        /* TODO */
    }

    /**
     * Cộng các phần tử của vector với value.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector addTo(double value) {
        /* TODO */
    }

    /**
     * Cộng vector hiện tại với một vector khác.
     * Nếu hai vector không cùng số chiều thì không cộng được.
     * In ra thông báo lỗi hoặc ném exception.
     * @param another
     * @return vector hiện tại.
     */
    public MyListVector addTo(MyVector another) {
        /* TODO */
    }

    /**
     * Trừ các phần tử của vector cho value.
     * @return vector mới.
     */
    public MyListVector minus(double value) {
        /* TODO */
    }

    /**
     * Trừ vector hiện tại cho vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector mới.
     */
    public MyListVector minus(MyVector another) {
        /* TODO */
    }

    /**
     * Trừ các phần tử của vector cho value.
     * @return vector hiện tại.
     */
    public MyListVector minusFrom(double value) {
        /* TODO */
    }

    /**
     * Trừ vector hiện tại cho vector khác.
     * Nếu hai vector không cùng số chiều thì không trừ được.
     * In ra thông báo lỗi hoặc ném exception.
     * @return vector hiện tại.
     */
    public MyListVector minusFrom(MyVector another) {
        /* TODO */
    }

    /**
     * Tích vô hướng của hai vector.
     * Hai vector chỉ có tích vô hướng nếu có cùng số chiều.
     * Nếu hai vector không cùng số chiều, in ra thông báo lỗi hoặc ném exception.
     * @return tích vô hướng.
     */
    public double dot(MyVector another) {
        /* TODO */
    }

    /**
     * Các phần tử vector được lấy mũ power.
     * @param power
     * @return vector hiện tại.
     */
    public MyListVector pow(double power) {
        /* TODO */
    }

    /**
     * Các phần tử vector được nhân với value.
     * @return vector hiện tại.
     */
    public MyListVector scale(double value) {
        /* TODO */
    }

    /**
     * Lấy chuẩn của vector.
     * @return chuẩn của vector.
     */
    @Override
    public double norm() {
        /* TODO */
    }

    /**
     * Thêm một giá trị value vào vector ở vị trí cuối cùng.
     * @param value
     * @return vector hiện tại.
     */
    public MyListVector insert(double value) {
        /* TODO */
    }

    /**
     * Thêm một giá trị vào vector ở vị trí index.
     * @param value
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector insert(double value, int index) {
        /* TODO */
    }

    /**
     * Xóa phần tử ở vị trí index.
     * Nếu index không hợp lệ thì in ra thông báo lỗi hoặc ném exception.
     * @param index
     * @return vector hiện tại.
     */
    public MyListVector remove(int index) {
        /* TODO */
    }

    /**
     * Trích xuất ra một vector con của vector ban đầu, có các phần tử
     * được lấy theo các chỉ số của mảng đầu vào.
     * Ví dụ, cho vector [1 2 3 4 5], cho mảng đầu vào là {2, 1} thì vector trích xuất ra
     * có tọa độ là [2 1].
     * Nếu có thỉ số trong mảng đầu vào không hợp lệ thì in ra thông báo lỗi,
     * hoặc ném exception.
     * @param indices
     * @return vector mới có kiểu MyListVector có các phần tử được trích xuất từ vector hiện tại.
     */
    public MyListVector extract(int[] indices) {
        /* TODO */
    }
}
