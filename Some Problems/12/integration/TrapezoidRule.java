package integration;

public class TrapezoidRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public TrapezoidRule(double precision, int maxIterations) {
        /* TODO */
    }

    /**
     * Tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        int n = 1;
        double I_n = integrate(polynomial, lower, upper, n);
        double I_2n = integrate(polynomial, lower, upper, 2 * n);
        while (Math.abs(I_2n - I_n) / 3 >= precision && n < maxIterations) {
            n *= 2;
            I_n = I_2n;
            I_2n = integrate(polynomial, lower, upper, 2 * n);
        }
        return I_2n;
    }

    /**
     * Tính xấp xỉ giá trị tích phân với numOfSubIntervals khoảng phân hoạch đều.
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        double h = (upper - lower) / numOfSubIntervals;
        double result = h * (polynomial.evaluate(lower) + polynomial.evaluate(upper)) / 2;
        for (int i = 1; i < numOfSubIntervals; i++) {
            double x0 = lower + i * h;
            double x1 = lower + (i + 1) * h;
            result += (polynomial.evaluate(x0) + polynomial.evaluate(x1)) * h / 2;
        }
        return result;
    }
}
