package com.codeHeap.swing.javaBeans.nonSync.bangbean;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.TooManyListenersException;

public class BangBean extends JPanel implements Serializable {
    private int xm;
    private int ym;
    private int cSize = 20;
    private String text = "Bang!";
    private int fontSize = 48;
    private Color color = Color.RED;
    private ActionListener actionListener = null;

    BangBean(){
        addMouseListener(new ML());
        addMouseMotionListener(new MML());
    }

    public int getcSize() {
        return cSize;
    }

    public void setcSize(int cSize) {
        this.cSize = cSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void addActionListener(ActionListener actionListener) throws TooManyListenersException {
        if(this.actionListener != null){
            throw new TooManyListenersException();
        }
        this.actionListener = actionListener;
    }

    public void removeActionListener() {
        this.actionListener = null;
    }

    class ML extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            Graphics graphics = getGraphics();
            graphics.setColor(color);
            graphics.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
            int width = graphics.getFontMetrics().stringWidth(text);
            int height = graphics.getFontMetrics().getHeight();
            graphics.drawString(text, (getSize().width-width)/2, getSize().height/2);
            graphics.dispose();
            if(actionListener != null){
                actionListener.actionPerformed(
                        new ActionEvent(BangBean.this,
                                ActionEvent.ACTION_PERFORMED,
                                null
                        )
                );
            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        graphics.drawOval(xm - cSize/2, ym - cSize/2, cSize, cSize);
    }

    class MML extends MouseMotionAdapter{
        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            xm = mouseEvent.getX();
            ym = mouseEvent.getY();
            repaint();
        }
    }

    public Dimension getPrefferedSize(){
        return new Dimension(200, 200);
    }
}
