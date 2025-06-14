package hus.oop.rootsolver;

public class MyMath {
    public static double sin(double x) {
        /* TODO */
        double sum = x;
        double previousSum = 0;
        double current = x;
        int turn = 1;
        while (Math.abs(sum - previousSum) > 0.000001) {
            previousSum = sum;
            int doubleTurn = turn * 2;
            current *= (x * x) /
                    (doubleTurn * (doubleTurn + 1));
            sum += Math.pow(-1, turn)
                    * current;
            turn++;
        }
        return sum;
    }

    public static double cos(double x) {
        /* TODO */
        double sum = 1;
        double previousSum = 0;
        double current = 1;
        int turn = 1;
        while (Math.abs(sum - previousSum) > 0.000001) {
            previousSum = sum;
            int doubleTurn = turn * 2;
            current *= (x * x) /
                    ((doubleTurn - 1) * doubleTurn);
            sum += Math.pow(-1, turn)
                    * current;
            turn++;
        }
        return sum;
    }

    public double exp(double x) {
        /* TODO */
        double sum = 1;
        double previousSum = 0;
        double current = 1;
        int turn = 1;
        while (Math.abs(sum - previousSum) > 0.000001) {
            previousSum = sum;
            current *= x / turn;
            sum += current;
            turn++;
        }
        return sum;
    }

    public double ln(double x) {
        /* TODO */
        double sum = x;
        double previousSum = 0;
        double current = x;
        int turn = 1;
        while (Math.abs(sum - previousSum) > 0.000001) {
            previousSum = sum;
            current *= x;
            sum += Math.pow(-1, turn) *
                    (current / (turn + 1));
            turn++;
        }
        return sum;
    }

    public double derivativeSin(double x) {
        return cos(x);
    }

    public double derivativeCos(double x) {
        return -1 * sin(x);
    }

    public double derivativeExp(double x) {
        return exp(x);
    }

    public double derivativeLnOf1PlusX(double x) {
        double sum = 1;
        double previousSum = 0;
        double current = 1;
        int turn = 1;
        while (Math.abs(sum - previousSum) > 0.000001) {
            previousSum = sum;
            current *= x;
            sum += Math.pow(-1, turn) * current;
            turn++;
        }
        return sum;
    }
}
