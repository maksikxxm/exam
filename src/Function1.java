import math.Invoke;

public class Function1 implements Invoke {
    @Override
    public double invoke(double x) {
        return -x*x+1.0/x;
    }
}
