package Painters;

import Converter.Converter;
import Fun.Function2;
import Fun.Pair;

import java.awt.*;

public class FunctionPainter2 implements Painter{
    private Color clr;
    private Converter cnv;
    Double step = 0.1;
    Pair t;
    private Function2 f;
    public FunctionPainter2(Converter cnv, Function2 f, Color color, Pair t, Double step){
        this.f = f;
        this.clr = color;
        this.cnv = cnv;
        this.step = step;
        this.t=t;
    }
    public FunctionPainter2(Converter cnv, Function2 f, Color color, Pair t){
        this.f = f;
        this.clr = color;
        this.cnv = cnv;
        this.t=t;
    }
    public void paint(Graphics g, int width, int height) {
        g.setColor(clr);
        for (Double i =  t.getX(); i <= t.getY(); i=i+step) {
            double x1Crt = f.invoke(i).getX();
            double y1Crt = f.invoke(i).getY();
            double x2Crt = f.invoke(i+step).getX();;
            double y2Crt = f.invoke(i+step).getY();
            g.drawLine(cnv.xCrt2Scr(x1Crt), cnv.yCrt2Scr(y1Crt), cnv.xCrt2Scr(x2Crt), cnv.yCrt2Scr(y2Crt));

        }

    }
    public void setColor(Color clr) {
        this.clr = clr;
    }

    public void setF(Function2 f) {
        this.f = f;
    }
}
