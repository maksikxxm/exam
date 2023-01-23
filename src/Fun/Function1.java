package Fun;

public class Function1 implements Invoke {
    @Override
    public Double invoke(Double x) {
        return -x*x+1.0/x;
    }
}
