package integration;

import java.util.*;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        coefficients = new ArrayList<>();
    }

    @Override
    public double coefficient(int index) {
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            result[i] = coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    @Override
    public MyListPolynomial add(double coefficient, int index) {
        if (index < 0 || index > coefficients.size()) {
            return this;
        }
        coefficients.add(index, coefficient);
        return this;
    }

    @Override
    public MyListPolynomial set(double coefficient, int index) {
        if (index < 0 || index >= coefficients.size()) {
            return this;
        }
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        return coefficients.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = coefficients.size() - 1; i >= 0 ; i--) {
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 1; i < coefficients.size(); i++) {
            result.append(coefficients.get(i) * i);
        }
        return result;
    }

    @Override
    public MyListPolynomial plus(MyPolynomial right) {
        MyListPolynomial another = (MyListPolynomial)(right);
        int maxSize = Math.max(coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            if (i < coefficients.size() && i < another.coefficients.size()) {
                coefficients.set(i, coefficients.get(i) + another.coefficients.get(i));
            } else if (i < another.coefficients.size()) {
                coefficients.add(another.coefficients.get(i));
            }
        }
        return this;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial right) {
        MyListPolynomial another = (MyListPolynomial)(right);
        int maxSize = Math.max(coefficients.size(), another.coefficients.size());
        for (int i = 0; i < maxSize; i++) {
            if (i < coefficients.size() && i < another.coefficients.size()) {
                coefficients.set(i, coefficients.get(i) - another.coefficients.get(i));
            } else if (i < another.coefficients.size()) {
                coefficients.add(-another.coefficients.get(i));
            }
        }
        return this;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial right) {
        MyListPolynomial another = (MyListPolynomial)(right);
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < coefficients.size() + another.coefficients.size() - 1; i++) {
            result.add(0.0);
        }
        for (int i = 0; i < coefficients.size(); i++) {
            for (int j = 0; j < another.coefficients.size(); j++) {
                result.set(i + j, result.get(i + j) + coefficients.get(i) * another.coefficients.get(j));
            }
        }
        coefficients = result;
        return this;
    }
}
