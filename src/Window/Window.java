package Window;

import javax.swing.*;
import java.awt.*;

import Converter.Converter;
import Painters.*;

public class Window extends JFrame {
    private Dimension minSize = new Dimension(600, 450);
    private controlPanel controlPanel;
    private GraphicsPanel mainPanel;
    private GroupLayout gl;
    int ControlPanelMax = 100;
    int ControlPanelMin = 100;
    int ControlPanelPref = 100;
    public Window(){
        setSize(minSize);
        setMinimumSize(minSize);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gl = new GroupLayout(this.getContentPane());
        setLayout(gl);

        mainPanel = new GraphicsPanel();
        controlPanel = new controlPanel(mainPanel);

        //region VerHor
        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addComponent(mainPanel,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,Integer.MAX_VALUE)
                .addGap(8)
                .addComponent(controlPanel, ControlPanelMin, ControlPanelPref, ControlPanelMax)
                .addGap(8)
        );
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addGroup(gl.createParallelGroup()
                        .addComponent(mainPanel,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
                        .addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
                )
                .addGap(8)
        );
        //endregion

    }
    @Override
    public void setVisible(boolean b)
    {
        super.setVisible(b);
        mainPanel.setBackground(Color.WHITE);
        Converter conv = new Converter((double) controlPanel.XminSpinner.getValue(),(double)controlPanel.XmaxSpinner.getValue(),
                (double) controlPanel.YminSpinner.getValue(),(double) controlPanel.YmaxSpinner.getValue(),
                mainPanel.getWidth(),mainPanel.getHeight());
        mainPanel.addPainter(new CartesianPainter(conv,Color.black));
        mainPanel.removePaintersByType(new CartesianPainter(conv,Color.black).getClass().toString());
    }
}