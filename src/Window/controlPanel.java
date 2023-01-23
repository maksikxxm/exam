package Window;

import Converter.Converter;
import Painters.CartesianPainter;
import Painters.FunctionPainter;
import Painters.PointsPainter;
import math.Newton;
import math.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class controlPanel extends JPanel {
    //region Поля
    Checkbox Point = new Checkbox();
    Checkbox Function = new Checkbox();
    Checkbox Derivative = new Checkbox();
    GraphicsPanel mainPanel;
    int SpinnerMinHor = 50;
    Map<Double,Double> tmp = new HashMap<>();

    int SpinnerPrefHor = GroupLayout.PREFERRED_SIZE;
    int SpinnerMaxHor = Integer.MAX_VALUE;

    int SpinnerMinVer = 30;
    int SpinnerPrefVer = 30;
    int SpinnerMaxVer = 45;
    JLabel Xmin= new JLabel("Xmin");
    double stepSize = 0.1;
    SpinnerNumberModel nmxmins = new SpinnerNumberModel(-5.0, -100.0, 4.9, stepSize);
    SpinnerNumberModel nmxmaxs = new SpinnerNumberModel(5.0, -4.9, 100.0, stepSize);
    SpinnerNumberModel nmymins = new SpinnerNumberModel(-5.0, -100.0, 4.9, stepSize);
    SpinnerNumberModel nmymaxs = new SpinnerNumberModel(5.0, -4.9, 100.0, stepSize);
    public JSpinner XminSpinner = new JSpinner(nmxmins);
    JLabel Ymin=new JLabel("Ymin");
    public JSpinner YminSpinner = new JSpinner(nmymins);
    JLabel Xmax= new JLabel("Xmax");
    public JSpinner XmaxSpinner = new JSpinner(nmxmaxs);
    JLabel  Ymax = new JLabel("Ymax");
    public JSpinner YmaxSpinner = new JSpinner(nmymaxs);


    JLabel pointColor = new JLabel("Point color");
    JLabel polynomialColor = new JLabel("Polynomial color");
    JLabel derivativeColor = new JLabel("Derivative color");

    int ColorPanelMin = 30;
    int ColorPanelPref = 30;
    int ColorPanelMax = 30;
    JPanel derivativeColorPanel = new JPanel();
    JPanel polynomialColorPanel = new JPanel();
    JPanel pointColorPanel = new JPanel();

    ArrayList<Pair> Points = new ArrayList<Pair>();
    //endregion
    public controlPanel(GraphicsPanel mainPanel)
    {
        Point.setState(true);
        Function.setState(true);
        Derivative.setState(true);
        Point.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Converter conv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                        (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                        mainPanel.getWidth(),mainPanel.getHeight());
                mainPanel.removeAllPainters();
                mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
                if(Function.getState())
                    mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                if(Point.getState())
                    mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                mainPanel.repaint();
            }
        });
        Function.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Converter conv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                        (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                        mainPanel.getWidth(),mainPanel.getHeight());
                mainPanel.removeAllPainters();
                mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
                if(Function.getState())
                    mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                if(Point.getState())
                    mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                mainPanel.repaint();
            }
        });
        Derivative.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Converter conv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                        (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                        mainPanel.getWidth(),mainPanel.getHeight());
                mainPanel.removeAllPainters();
                mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
                if(Function.getState())
                    mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                if(Point.getState())
                    mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                mainPanel.repaint();
            }
        });

        this.mainPanel = mainPanel;
        GroupLayout cpgl = new GroupLayout(this);
        this.setLayout(cpgl);

        this.setBackground(Color.white);

        pointColorPanel.setBackground(Color.red);
        pointColorPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color color=JColorChooser.showDialog(pointColorPanel,"Выберите цвет",Color.WHITE);
                if(color !=null)
                    pointColorPanel.setBackground(color);
                mainPanel.removeAllPainters();
                Converter conv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                        (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                        mainPanel.getWidth(),mainPanel.getHeight());
                mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
                if(Function.getState())
                    mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                if(Point.getState())
                    mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                mainPanel.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        polynomialColorPanel.setBackground(Color.green);
        polynomialColorPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color color=JColorChooser.showDialog(polynomialColorPanel,"Выберите цвет",Color.WHITE);
                if(color !=null)
                    polynomialColorPanel.setBackground(color);
                mainPanel.removeAllPainters();
                Converter conv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                        (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                        mainPanel.getWidth(),mainPanel.getHeight());
                mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
                if(Function.getState())
                    mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                if(Point.getState())
                    mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                mainPanel.repaint();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        derivativeColorPanel.setBackground(Color.blue);
        derivativeColorPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color color=JColorChooser.showDialog(derivativeColorPanel,"Выберите цвет",Color.WHITE);
                if(color !=null)
                    derivativeColorPanel.setBackground(color);
                mainPanel.removeAllPainters();
                Converter conv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                        (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                        mainPanel.getWidth(),mainPanel.getHeight());
                mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
                if(Function.getState())
                    mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                if(Point.getState())
                    mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                mainPanel.repaint();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        XminSpinner.addChangeListener(e -> {
            nmxmaxs.setMinimum((Double)nmxmins.getValue() + 2 * (Double)nmxmaxs.getStepSize());
            Converter conv = new Converter((double) this.XminSpinner.getValue(),(double) this.XmaxSpinner.getValue(),
                    (double) this.YminSpinner.getValue(),(double) this.YmaxSpinner.getValue(),
                    mainPanel.getWidth(),mainPanel.getHeight());
            mainPanel.removeAllPainters();
            mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
            if(Function.getState())
                mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
            if(Derivative.getState())
                mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
            if(Point.getState())
                mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));

            mainPanel.repaint();
        });
        XmaxSpinner.addChangeListener(e -> {
            nmxmins.setMaximum((Double)nmxmaxs.getValue() - 2 * (Double)nmxmins.getStepSize());
            Converter conv = new Converter((double) this.XminSpinner.getValue(),(double) this.XmaxSpinner.getValue(),
                    (double) this.YminSpinner.getValue(),(double) this.YmaxSpinner.getValue(),
                    mainPanel.getWidth(),mainPanel.getHeight());
            mainPanel.removeAllPainters();
            mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
            if(Function.getState())
                mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
            if(Derivative.getState())
                mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
            if(Point.getState())
                mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));

            mainPanel.repaint();

        });
        YminSpinner.addChangeListener(e -> {
            nmymaxs.setMinimum((Double)nmymins.getValue() + 2 * (Double)nmymaxs.getStepSize());
            Converter conv = new Converter((double) this.XminSpinner.getValue(),(double) this.XmaxSpinner.getValue(),
                    (double) this.YminSpinner.getValue(),(double) this.YmaxSpinner.getValue(),
                    mainPanel.getWidth(),mainPanel.getHeight());
            mainPanel.removeAllPainters();
            mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
            if(Function.getState())
                mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
            if(Derivative.getState())
                mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
            if(Point.getState())
                mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));

            mainPanel.repaint();
        });
        YmaxSpinner.addChangeListener(e -> {
            nmymins.setMaximum((Double)nmymaxs.getValue() - 2 * (Double)nmymins.getStepSize());
            Converter conv = new Converter((double) this.XminSpinner.getValue(),(double) this.XmaxSpinner.getValue(),
                    (double) this.YminSpinner.getValue(),(double) this.YmaxSpinner.getValue(),
                    mainPanel.getWidth(),mainPanel.getHeight());
            mainPanel.removeAllPainters();
            mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
            if(Function.getState())
                mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
            if(Derivative.getState())
                mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
            if(Point.getState())
                mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));

            mainPanel.repaint();

        });


        mainPanel.addComponentListener(new ComponentAdapter()
        {
            public void componentResized(ComponentEvent evt) {
                Converter conv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                        (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                        mainPanel.getWidth(),mainPanel.getHeight());
                mainPanel.removeAllPainters();
                mainPanel.addPainter(new CartesianPainter(conv, Color.BLACK));
                if(Function.getState() && tmp.get(0)!=null )
                    mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
                if(Derivative.getState()&& tmp.get(0)!=null)
                    mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                if(Point.getState())
                    mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                mainPanel.repaint();
            }
        });

        mainPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 1)
                {
                    Converter conv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                            (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                            mainPanel.getWidth(),mainPanel.getHeight());
                    if(Points.size()==0)
                    {
                        Points.add(new Pair(conv.xScr2Crt(e.getX()), conv.yScr2Crt(e.getY())));
                    }
                    else
                    {
                        for (int i = 0; i< Points.size(); i++) {
                            if (conv.xDistCrt2Scr(conv.xScr2Crt(e.getX()), Points.get(i).getX()) <
                                    conv.xDistCrt2Scr(0.0, Math.max(((double) (XmaxSpinner.getValue()) - (double) XminSpinner.getValue()) / 100., 0.15))) {
                                return;
                            }
                        }
                                Points.add(new Pair(conv.xScr2Crt(e.getX()), conv.yScr2Crt(e.getY())));
                    }
                    for(int i=0; i<Points.size();i++)
                        tmp.put(Points.get(i).getX(),Points.get(i).getY());
                    mainPanel.removeAllPainters();
                    mainPanel.addPainter(new CartesianPainter(conv,Color.black));
                    if(Function.getState())
                        mainPanel.addPainter(new FunctionPainter(conv, new Newton(tmp),polynomialColorPanel.getBackground()));
                    if(Derivative.getState())
                        mainPanel.addPainter(new FunctionPainter(conv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                    if(Point.getState())
                        mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                    mainPanel.repaint();

                }
                else
                {
                    Converter cnv = new Converter((double) XminSpinner.getValue(),(double) XmaxSpinner.getValue(),
                            (double) YminSpinner.getValue(),(double) YmaxSpinner.getValue(),
                            mainPanel.getWidth(),mainPanel.getHeight());
                    for (int i =0;i<Points.size();i++) {
                        if (cnv.xDistCrt2Scr(cnv.xScr2Crt(e.getX()), Points.get(i).getX()) <
                                cnv.xDistCrt2Scr(0.0, Math.min(((double) (XmaxSpinner.getValue()) - (double) XminSpinner.getValue()) / 100., 0.05)) &&
                                cnv.yDistCrt2Scr(cnv.yScr2Crt(e.getY()), Points.get(i).getY()) <
                                        cnv.xDistCrt2Scr(0.0, Math.min(((double) (XmaxSpinner.getValue()) - (double) XminSpinner.getValue()) / 100., 0.05))) {

                            Points.remove(i);
                        tmp.clear();
                        for(int j=0; j<Points.size();j++)
                            tmp.put(Points.get(j).getX(),Points.get(j).getY());
                        mainPanel.removeAllPainters();
                        mainPanel.addPainter(new CartesianPainter(cnv,Color.black));
                        if(Function.getState())
                            mainPanel.addPainter(new FunctionPainter(cnv, new Newton(tmp),polynomialColorPanel.getBackground()));
                        if(Derivative.getState())
                            mainPanel.addPainter(new FunctionPainter(cnv,new Newton(tmp).derivative(),derivativeColorPanel.getBackground()));
                        if(Point.getState())
                            mainPanel.addPainter(new PointsPainter(cnv,Points,pointColorPanel.getBackground()));
                        mainPanel.repaint();
                        }
                    }
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //region HorVer
        cpgl.setHorizontalGroup(cpgl.createSequentialGroup()
                .addGap(5)
                .addGroup(cpgl.createParallelGroup()
                        .addGroup(cpgl.createSequentialGroup()
                                .addComponent(Xmin)
                                .addGap(5)
                                .addComponent(XminSpinner,SpinnerMinHor,SpinnerPrefHor,SpinnerMaxHor)
                        )
                        .addGroup(cpgl.createSequentialGroup()
                                .addComponent(Ymin)
                                .addGap(5)
                                .addComponent(YminSpinner,SpinnerMinHor,SpinnerPrefHor,SpinnerMaxHor)
                        )
                )
                .addGap(5)
                .addGroup(cpgl.createParallelGroup()
                        .addGroup(cpgl.createSequentialGroup()
                                .addComponent(Xmax)
                                .addGap(5)
                                .addComponent(XmaxSpinner,SpinnerMinHor,SpinnerPrefHor,SpinnerMaxHor)
                        )
                        .addGroup(cpgl.createSequentialGroup()
                                .addComponent(Ymax)
                                .addGap(5)
                                .addComponent(YmaxSpinner,SpinnerMinHor,SpinnerPrefHor,SpinnerMaxHor)
                        )
                )
                .addGap(5,5,Integer.MAX_VALUE)
                .addGroup(cpgl.createParallelGroup()
                        .addGroup(cpgl.createSequentialGroup()
                                .addComponent(Point,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addComponent(pointColorPanel,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addGap(2)
                                .addComponent(pointColor)
                        )
                        .addGroup(cpgl.createSequentialGroup()
                                .addComponent(Function,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addComponent(polynomialColorPanel,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addGap(2)
                                .addComponent(polynomialColor)
                        )
                        .addGroup(cpgl.createSequentialGroup()
                                .addComponent(Derivative,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addComponent(derivativeColorPanel,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addGap(2)
                                .addComponent(derivativeColor)
                        )
                )
                .addGap(5)
        );
        cpgl.setVerticalGroup(cpgl.createParallelGroup()
                .addGroup(cpgl.createSequentialGroup()
                        .addGap(5)
                        .addGroup(cpgl.createParallelGroup()
                                .addComponent(Xmin, GroupLayout.Alignment.CENTER)
                                .addComponent(XminSpinner,SpinnerMinVer,SpinnerPrefVer,SpinnerMaxVer)
                        )
                        .addGroup(cpgl.createParallelGroup()
                                .addComponent(Ymin, GroupLayout.Alignment.CENTER)
                                .addComponent(YminSpinner,SpinnerMinVer,SpinnerPrefVer,SpinnerMaxVer)
                        )
                )
                .addGroup(cpgl.createSequentialGroup()
                        .addGap(5)
                        .addGroup(cpgl.createParallelGroup()
                                .addComponent(Xmax, GroupLayout.Alignment.CENTER)
                                .addComponent(XmaxSpinner,SpinnerMinVer,SpinnerPrefVer,SpinnerMaxVer)
                        )
                        .addGroup(cpgl.createParallelGroup()
                                .addComponent(Ymax, GroupLayout.Alignment.CENTER)
                                .addComponent(YmaxSpinner,SpinnerMinVer,SpinnerPrefVer,SpinnerMaxVer)
                        )
                )
                .addGroup(cpgl.createSequentialGroup()
                        .addGap(5)
                        .addGroup(cpgl.createParallelGroup()
                                .addComponent(Point,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addComponent(pointColorPanel,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addComponent(pointColor, GroupLayout.Alignment.CENTER)
                        )
                        .addGroup(cpgl.createParallelGroup()
                                .addComponent(Function,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addComponent(polynomialColorPanel,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addComponent(polynomialColor, GroupLayout.Alignment.CENTER)
                        )
                        .addGroup(cpgl.createParallelGroup()
                                .addComponent(Derivative,ColorPanelMin,ColorPanelPref,ColorPanelMax)
                                .addComponent(derivativeColorPanel, ColorPanelMin, ColorPanelPref,ColorPanelMax)
                                .addComponent(derivativeColor, GroupLayout.Alignment.CENTER)
                        )
                )
        );
        //endregion

    }
}
