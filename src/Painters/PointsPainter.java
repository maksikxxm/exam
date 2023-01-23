package Painters;

import Converter.Converter;
import math.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PointsPainter implements Painter {
    private Color clr;
    private Converter cnv;
    private ArrayList<Pair> points = new ArrayList<>();
    public PointsPainter(Converter cnv, Collection<Pair> a, Color color){
        this.clr = color;
        this.cnv = cnv;
        points.addAll(a);
    }

    @Override
    public void paint(Graphics g, int width, int height) {
            g.setColor(clr);
            for (int i =0; i<points.size();i++) {
                int x = cnv.xCrt2Scr(points.get(i).getX());
                int y = cnv.yCrt2Scr(points.get(i).getY());
                g.fillOval(x-3, y-3, 6, 6);
            }
    }

    public void addPoint(Pair a) {
        this.points.add(a);
    }
    public void removePoint(Pair a){this.points.remove(a);}

    public void setColor(Color clr) {
        this.clr = clr;
    }
}
