package Painters;

import java.awt.*;

import Converter.Converter;
import Fun.Invoke;

public class FunctionPainter1 implements Painter {
    private Color clr;
    private Converter cnv;
    private Invoke f;
   public FunctionPainter1(Converter cnv, Invoke f, Color color){
       this.f = f;
       this.clr = color;
       this.cnv = cnv;
   }
    public void paint(Graphics g, int width, int height) {
            g.setColor(clr);
            for (int i = 0; i < width - 1; i++) {
                double x1Crt = cnv.xScr2Crt(i);
                double y1Crt = (double)f.invoke(x1Crt);
                double x2Crt = cnv.xScr2Crt(i + 1);
                double y2Crt = (double)f.invoke(x2Crt);
                g.drawLine(cnv.xCrt2Scr(x1Crt), cnv.yCrt2Scr(y1Crt), cnv.xCrt2Scr(x2Crt), cnv.yCrt2Scr(y2Crt));

            }

    }
    public void setColor(Color clr) {
        this.clr = clr;
    }

    public void setF(Invoke f) {
        this.f = f;
    }
}
