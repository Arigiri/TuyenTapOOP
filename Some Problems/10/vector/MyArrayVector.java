package hus.oop.vector;

public class MyArrayVector extends MyAbstractVector {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
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
    public MyArrayVector insert(double value) {
        /* TODO */
    }

    @Override
    public MyArrayVector insert(double value, int index) {
        /* TODO */
    }

    @Override
    public MyArrayVector remove(int index) {
        /* TODO */
    }

    @Override
    public MyArrayVector extract(int[] indices) {
        /* TODO */
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
    }

    @Override
    public MyArrayVector add(double value) {
        /* TODO */
    }

    @Override
    public MyArrayVector add(MyVector another) {
        /* TODO */
    }

    @Override
    public MyArrayVector addTo(double value) {
        /* TODO */
    }

    @Override
    public MyArrayVector addTo(MyVector another) {
        /* TODO */
    }

    @Override
    public MyArrayVector minus(double value) {
        /* TODO */
    }

    @Override
    public MyArrayVector minus(MyVector another) {
        /* TODO */
    }

    @Override
    public MyArrayVector minusFrom(double value) {
        /* TODO */
    }

    @Override
    public MyArrayVector minusFrom(MyVector another) {
        /* TODO */
    }

    @Override
    public double dot(MyVector another) {
        /* TODO */
    }

    @Override
    public MyArrayVector pow(double power) {
        /* TODO */
    }

    @Override
    public MyArrayVector scale(double value) {
        /* TODO */
    }

    @Override
    public double norm() {
        /* TODO */
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
    }
}
