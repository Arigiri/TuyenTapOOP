package integration;

public class MidpointRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public MidpointRule(double precision, int maxIterations) {
        this.maxIterations = maxIterations;
        this.precision = precision;
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
        /* TODO */
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
        /* TODO */
        double h = (upper - lower) / numOfSubIntervals;
        double result = 0;
        for (int i = 0; i < numOfSubIntervals; i++) {
            double midpoint = lower + (i + 0.5) * h;
            result += polynomial.evaluate(midpoint) * h;
        }
        return result;
    }
}
