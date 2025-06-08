package integration;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        this.coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            result[i] = coefficents[i];
        }
        return result;
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        if (size == coefficents.length) {
            allocateMore();
        }
        coefficents[size++] = coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        if (index < 0 || index > size) {
            return this;
        }
        if (size == coefficents.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            coefficents[i] = coefficents[i - 1];
        }
        coefficents[index] = coefficient;
        size++;
        return this;
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= size) {
            return this;
        }
        coefficents[index] = coefficient;
        return this;
    }

    @Override
    public int degree() {
        return size - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = size - 1; i >= 0; i--) {
            result = result * x + coefficents[i];
        }
        return result;
    }

    @Override
    public MyPolynomial derivative() {
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 1; i < size; i++) {
            result.append(coefficents[i] * i);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        MyArrayPolynomial another = (MyArrayPolynomial)(right);
        int maxLength = Math.max(size, another.size);
        for (int i = 0; i < maxLength; i++) {
            if (i < size && i < another.size) {
                coefficents[i] += another.coefficents[i];
            } else if (i >= size && i < another.size) {
                append(another.coefficents[i]);
            }
        }
        return this;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        MyArrayPolynomial another = (MyArrayPolynomial)(right);
        int maxLength = Math.max(size, another.size);
        for (int i = 0; i < maxLength; i++) {
            if (i < size && i < another.size) {
                coefficents[i] -= another.coefficents[i];
            } else if (i >= size && i < another.size) {
                append(-another.coefficents[i]);
            }
        }
        return this;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        MyArrayPolynomial another = (MyArrayPolynomial)(right);
        double[] result = new double[size + another.size - 1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < another.size; j++) {
                result[i + j] += coefficents[i] * another.coefficents[j];
            }
        }
        coefficents = result;
        size = result.length;
        return this;
    }

    /**
     * Tăng kích thước mảng lên gấp đôi để lưu đa thức khi cần thiết.
     */
    private void allocateMore() {
        double[] newCoefficients = new double[coefficents.length * 2];
        if (size >= 0) System.arraycopy(coefficents, 0, newCoefficients, 0, size);
        coefficents = newCoefficients;
    }
}
