package hus.oop.rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    @Override
    public double evaluate(double x) {
        /* TODO */
        MyMath myMath = new MyMath();
        return x * myMath.sin(x) - 3;
    }

    @Override
    public double derivative(double x) {
        /* TODO */
        MyMath myMath = new MyMath();
        return myMath.sin(x) + x * myMath.cos(x);
    }
}
