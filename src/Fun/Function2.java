package Fun;

public class Function2 implements Invoke {
    @Override
    public Pair invoke(Double t) {
        Pair a =  new Pair((t*t+1)/(4*t-4),t/(t+1));
        return a;
    }
}
