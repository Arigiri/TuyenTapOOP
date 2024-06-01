package hus.oop.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double mid = 0;
        int count = 0;
        while (Math.abs(upper - lower) > tolerance && count < maxIterations) {
            mid = (upper + lower) / 2;
            double fa = function.evaluate(lower);
            double fmid = function.evaluate(mid);
            if (fa * fmid < 0) {
                upper = mid;
            } else if (fa * fmid > 0) {
                lower = mid;
            } else {
                break;
            }
            count++;
        }
        return mid;
    }
}
