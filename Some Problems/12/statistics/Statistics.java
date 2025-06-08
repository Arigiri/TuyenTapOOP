package statistics;

import java.util.Arrays;

public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        MyIterator iterator = data.iterator(0);
        double max = (double) iterator.next();
        while (iterator.hasNext()) {
            double current = (double) iterator.next();
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        if (data.size() == 0) {
            throw new IllegalStateException("List is empty");
        }
        MyIterator iterator = data.iterator(0);
        double min = (double) iterator.next();
        while (iterator.hasNext()) {
            double current = (double) iterator.next();
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        if (data.size() == 0) {
            return 0; // Or throw exception
        }
        double sum = 0;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            sum += (double) iterator.next();
        }
        return sum / data.size();
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     * @return phương sai.
     */
    public double variance() {
        if (data.size() <= 1) {
            return 0; // Or throw exception, variance of single point is 0 or undefined
        }
        double mean = mean();
        double sumOfSquares = 0;
        MyIterator iterator = data.iterator(0);
        while (iterator.hasNext()) {
            double val = (double) iterator.next();
            sumOfSquares += (val - mean) * (val - mean);
        }
        return sumOfSquares / (data.size() - 1); // Sample variance
    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     * @return
     */
    public int search(double searchValue) {
        return data.binarySearch(searchValue);
    }

    /**
     * Tính rank của các phần tử trong list.
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        if (data.size() == 0) {
            return new double[0];
        }

        double[] values = new double[data.size()];
        MyIterator iterator = data.iterator(0);
        int i = 0;
        while (iterator.hasNext()) {
            values[i++] = (double) iterator.next();
        }

        double[] sortedValues = Arrays.copyOf(values, values.length);
        Arrays.sort(sortedValues);

        double[] ranks = new double[values.length];
        for (i = 0; i < values.length; i++) {
            double valueToRank = values[i];
            int countSmaller = 0;
            int countEqual = 0;
            for (double sortedValue : sortedValues) {
                if (sortedValue < valueToRank) {
                    countSmaller++;
                }
                if (sortedValue == valueToRank) {
                    countEqual++;
                }
            }
            ranks[i] = countSmaller + (countEqual + 1.0) / 2.0;
        }
        return ranks;
    }
}
