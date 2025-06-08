package matrix;

public class MySquareMatrix {
    private int[][] data;
    private java.util.Random random = new java.util.Random();

    /**
     * Hàm dựng, khởi tạo một ma trận có các phần tử được sinh ngẫu nhiên trong khoảng [1, 100]
     * @param size
     */
    public MySquareMatrix(int size) {
        initRandom(size);
    }

    /**
     * Phương thức khởi tạo ma trận, các phần tử của ma trận được sinh ngẫu nhiên trong đoạn [10, 90]
     * @param size
     */
    private void initRandom(int size) {
        if (size <= 0) {

            this.data = new int[0][0];
            return;
        }
        this.data = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.data[i][j] = random.nextInt(81) + 10;
            }
        }
    }

    /**
     * Lấy ra các phần tử trên đường chéo chính của ma trận.
     * @return đường chéo chính của ma trận.
     */
    public int[] principalDiagonal() {
        if (data == null || data.length == 0) {
            return new int[0];
        }
        int size = data.length;
        int[] diagonal = new int[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = data[i][i];
        }
        return diagonal;
    }

    /**
     * Lấy ra các phần tử trên đường chéo phụ của ma trận.
     * @return đường chéo phụ của ma trận.
     */
    public int[] secondaryDiagonal() {
        if (data == null || data.length == 0) {
            return new int[0];
        }
        int size = data.length;
        int[] diagonal = new int[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = data[i][size - 1 - i];
        }
        return diagonal;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Phương thức lấy ra các số là số nguyên tố trong ma trận.
     * @return các số nguyên tố trong ma trận.
     */
    public int[] primes() {
        if (data == null || data.length == 0) {
            return new int[0];
        }
        java.util.List<Integer> primeList = new java.util.ArrayList<>();
        for (int[] row : data) {
            for (int val : row) {
                if (isPrime(val)) {
                    primeList.add(val);
                }
            }
        }
        int[] result = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            result[i] = primeList.get(i);
        }
        return result;
    }

    /**
     * Sắp xếp các phần tử của ma trận theo thứ tự giảm dần.
     * @return ma trận có các phần tử là phần tử của ma trận ban đầu được sắp xếp theo thứ tự giảm dần.
     * Các phần tử được sắp xếp theo thứ tự từ trái sang phải ở mỗi hàng, và từ trên xuống dưới.
     */
    public MySquareMatrix getSortedMatrix() {
        if (data == null || data.length == 0) {
            return new MySquareMatrix(0);
        }
        int size = data.length;
        java.util.List<Integer> elements = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                elements.add(data[i][j]);
            }
        }
        java.util.Collections.sort(elements, java.util.Collections.reverseOrder());

        MySquareMatrix sortedMatrix = new MySquareMatrix(size);
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sortedMatrix.set(i, j, elements.get(k++));
            }
        }
        return sortedMatrix;
    }

    /**
     * Lấy giá trị phần tử ở vị trí (row, col).
     * @param row
     * @param col
     * @return
     */
    public int get(int row, int col) {

        if (data != null && row >= 0 && row < data.length && col >= 0 && col < data[0].length) {
            return data[row][col];
        }

        return -1;
    }

    /**
     * Sửa giá trị phần tử ở vị trí (row, col) thành value.
     * @param row
     * @param col
     * @param value
     */
    public void set(int row, int col, int value) {

        if (data != null && row >= 0 && row < data.length && col >= 0 && col < data[0].length) {
            data[row][col] = value;
        }

    }

    /**
     * Cộng ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận tổng của 2 ma trận.
     */
    public MySquareMatrix add(MySquareMatrix that) {
        if (this.data == null || that.data == null || this.data.length != that.data.length || this.data.length == 0 || this.data[0].length != that.data[0].length) {

            return new MySquareMatrix(0);
        }
        int size = this.data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(i, j, this.get(i, j) + that.get(i, j));
            }
        }
        return result;
    }

    /**
     * Trừ ma trận hiện tại cho một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận hiệu của ma trận hiện tại và ma trận truyền vào.
     */
    public MySquareMatrix minus(MySquareMatrix that) {
        if (this.data == null || that.data == null || this.data.length != that.data.length || this.data.length == 0 || this.data[0].length != that.data[0].length) {

            return new MySquareMatrix(0);
        }
        int size = this.data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(i, j, this.get(i, j) - that.get(i, j));
            }
        }
        return result;
    }

    /**
     * Nhân ma trận hiện tại với một ma trận khác.
     * @param that
     * @return ma trận mới là ma trận nhân của ma trận hiện tại với ma trận truyền vào.
     */
    public MySquareMatrix multiply(MySquareMatrix that) {
        if (this.data == null || that.data == null || this.data.length != that.data.length || this.data.length == 0 || this.data[0].length != that.data[0].length) {

            return new MySquareMatrix(0);
        }
        int size = this.data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += this.get(i, k) * that.get(k, j);
                }
                result.set(i, j, sum);
            }
        }
        return result;
    }

    /**
     * Nhân ma trận với một số vô hướng.
     * @param value
     * @return ma trận mới là ma trận hiện tại được nhân với một số vô hướng.
     */
    public MySquareMatrix scaled(int value) {
        if (data == null || data.length == 0) {
            return new MySquareMatrix(0);
        }
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(i, j, this.get(i, j) * value);
            }
        }
        return result;
    }

    /**
     * Phương thức lấy ma trận chuyển vị.
     * @return ma trận mới là ma trận chuyển vị của ma trận hiện tại.
     */
    public MySquareMatrix transpose() {
        if (data == null || data.length == 0) {
            return new MySquareMatrix(0);
        }
        int size = data.length;
        MySquareMatrix result = new MySquareMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.set(j, i, this.get(i, j));
            }
        }
        return result;
    }

    /**
     * Mô tả ma trận theo định dạng biểu diễn ma trận, ví dụ
     *   1 2 3
     *   4 5 6
     *   7 8 9
     * @return một chuỗi mô tả ma trận.
     */
    @Override
    public String toString() {
        if (data == null || data.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sb.append(data[i][j]);
                if (j < data[i].length - 1) {
                    sb.append(" ");
                }
            }
            if (i < data.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
