package Window;

import Converter.Converter;
import Fun.Function1;
import Painters.CartesianPainter;
import Painters.FunctionPainter1;
import Painters.FunctionPainter2;
import Painters.PointsPainter;
import Fun.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class controlPanel extends JPanel {
    //region Поля
    Checkbox Point = new Checkbox();
    Checkbox Function = new Checkbox();
    Checkbox Derivative = new Checkbox();
    GraphicsPanel mainPanel;
    int SpinnerMinHor = 50;
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
                    mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                    mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                    mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                    mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                    mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                    mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
            if(Derivative.getState())
                mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
            if(Derivative.getState())
                mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
            if(Derivative.getState())
                mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
            if(Derivative.getState())
                mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
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
                if(Function.getState())
                    mainPanel.addPainter(new FunctionPainter1(conv, new Function1(),polynomialColorPanel.getBackground()));
                if(Derivative.getState())
                    mainPanel.addPainter(new FunctionPainter1(conv,new Function1(),derivativeColorPanel.getBackground()));
                if(Point.getState())
                    mainPanel.addPainter(new PointsPainter(conv,Points,pointColorPanel.getBackground()));
                mainPanel.repaint();
            }
        });

        mainPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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
