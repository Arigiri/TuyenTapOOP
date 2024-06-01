package hus.oop.fraction;

import java.util.List;

public class MyListDataSet implements MyDataSet {
    private List<MyFraction> fractions;

    /**
     * Hàm dựng khởi tạo list chứa các phân số.
     */
    public MyListDataSet() {

    }

    /**
     * Hàm dựng khởi tạo list chứa các phân số theo truyền vào.
     * @param fractions
     */
    public MyListDataSet(List<MyFraction> fractions) {

    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        /* TODO */
    }

    @Override
    public boolean append(MyFraction fraction) {
        /* TODO */
    }

    @Override
    public MyListDataSet toSimplify() {
        /* TODO */
    }

    public MyListDataSet sortIncreasing() {
        /* TODO */
    }

    public MyListDataSet sortDecreasing() {
        /* TODO */
    }

    @Override
    public String myDataSetToString() {
        /* TODO */
    }

    @Override
    public void print() {
        /* TODO */
    }
}
