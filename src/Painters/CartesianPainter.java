package Painters;

import java.awt.*;

import Converter.Converter;

public class CartesianPainter implements Painter {
    Converter cnv;
    Color color;
    public  CartesianPainter(Converter conv,Color color)
    {
        this.cnv = conv;
        this.color=color;
    }
    public void changeConverter(Converter conv)
    {
        this.cnv = conv;
    }

    public void changeConverterClone(Converter conv)
    {
        this.cnv = conv.clone();
    }
    @Override
    public void paint(Graphics g, int width, int height) {
        double xMin = (Double) cnv.getxMin();
        double xMax = (Double) cnv.getxMax();
        double yMin = (Double) cnv.getyMin();
        double yMax = (Double) cnv.getyMax();
        g.setColor(color);
        int xCenter = cnv.xCrt2Scr(0);
        int yCenter = cnv.yCrt2Scr(0);
        g.drawLine(xCenter+1, 0, xCenter+1, height);
        g.drawLine(0, yCenter, width, yCenter);
        int th = 2;
        if (cnv.getxMax() * cnv.getyMin() < 0) {
            //рисуем штрихи на оси у
            for(double i = cnv.getyMin(); i < cnv.getyMax(); i+=0.1){
                if (Math.abs(i) < 1.e-8) { continue; }
                if(Math.round(10*i)%10 == 0){
                    th+=4;
                    //вывести координату
                    if(Math.round(i)!=0){
                        g.drawString(Double.toString(Math.round(i)), xCenter+4, cnv.yCrt2Scr(i));}
                }
                else if(Math.round(10*i)%5==0){
                    th+=2;
                }
                g.drawLine(xCenter-th, cnv.yCrt2Scr(i), xCenter+th, cnv.yCrt2Scr(i));
                th = 2;
            }
        }
        else {
            //рисуем штрихи по бокам
            for(double i = cnv.getyMin(); i<cnv.getyMax();i+=0.1){
                if (Math.abs(i) < 1.e-8) { continue; }
                if(Math.round(10*i)%10 == 0){
                    th+=4;
                    //вывести координату
                    g.drawString(Double.toString(Math.round(i)), 4, cnv.yCrt2Scr(i));
                    g.drawString(Double.toString(Math.round(i)), width-25, cnv.yCrt2Scr(i));
                }
                else if(Math.round(10*i)%5==0){
                    th+=2;
                }
                g.drawLine(0, cnv.yCrt2Scr(i), th, cnv.yCrt2Scr(i));
                g.drawLine(width-th-1, cnv.yCrt2Scr(i), width, cnv.yCrt2Scr(i));
                th = 2;
            }
        }
        if (cnv.getyMax() * cnv.getyMin() < 0)  {
            //рисуем штрихи на оси х
            for(double i = cnv.getxMin(); i<cnv.getxMax();i+=0.1){
                if (Math.abs(i) < 1.e-8) { continue; }
                if(Math.round(10*i)%10 == 0){
                    th+=4;
                    //вывести координату
                    if(Math.round(i) != 0) g.drawString(Double.toString(Math.round(i)), cnv.xCrt2Scr(i)-8, yCenter-5);
                }
                else if(Math.round(10*i)%5 == 0){
                    th+=2;
                }
                g.drawLine(cnv.xCrt2Scr(i), yCenter-th, cnv.xCrt2Scr(i), yCenter+th);
                th = 2;
            }
        }
        else {
            //рисуем штрихи сверху и снизу
            for(double i = cnv.getxMin(); i<cnv.getxMax();i+=0.1){
                if (Math.abs(i) < 1.e-8) { continue; }
                if(Math.round(10*i)%10 == 0){
                    th+=4;
                    //вывести координату
                    g.drawString(Double.toString(Math.round(i)), cnv.xCrt2Scr(i)-8, 10);
                    g.drawString(Double.toString(Math.round(i)), cnv.xCrt2Scr(i)-8, height-8);
                }
                else if(Math.round(10*i)%5==0){
                    th+=2;
                }
                g.drawLine(cnv.xCrt2Scr(i), 0, cnv.xCrt2Scr(i), th);
                g.drawLine(cnv.xCrt2Scr(i), height-th-1, cnv.xCrt2Scr(i), height);
                th = 2;
            }
        }
        g.drawString("0.0", xCenter+20*(int)(Math.signum(cnv.getxMin())* (int)Math.signum(cnv.getxMax())),
                yCenter - 15*(int)Math.signum(cnv.getyMin())*(int)Math.signum(cnv.getyMax()));
    }

}
