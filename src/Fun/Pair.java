package Fun;

public class Pair {
    double x,y;

    public Pair(double x, double y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Pair obj){
        var other = (Pair)obj;
        return (x == other.x) && (y == other.y);
    }


    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}
