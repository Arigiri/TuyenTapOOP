package hus.oop.search;

public class BubbleSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Bubble sort.
     * @param data
     * @param order: true sắp xếp theo thứ tự tăng dần, false sắp xếp theo thứ tự giảm dần.
     */
    @Override
    public void sort(double[] data, boolean order) {
        /* TODO */
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Bubble sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        /* TODO */
        boolean changed;
        for (int i = 0; i < data.length - 1; i++) {
            changed = true;
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    double temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    changed = false;
                }
            }
            if (changed) {
                break;
            }
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Bubble sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        /* TODO */
        boolean changed;
        for (int i = 0; i < data.length - 1; i++) {
            changed = true;
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] < data[j]) {
                    double temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    changed = false;
                }
            }
            if (changed) {
                break;
            }
        }
    }
}
