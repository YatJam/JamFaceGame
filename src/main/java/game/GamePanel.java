package game;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel {

private MouseInputs mouseInputs;
private int xDelta = 100;
private int yDelta = 100;
private BufferedImage image;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        importImage();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void importImage(){
        InputStream is = getClass().getResourceAsStream("/JamFace.png");
        try {
            image = ImageIO.read(is);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setPanelSize(){
        Dimension size = new Dimension(800,600);
        setMinimumSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
    }

    public void changeXDelta(int value){
        this.xDelta += value;
        repaint();
    }

    public void changeYDelta(int value){
        this.yDelta += value;
        repaint();
    }

    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

      g.drawImage(image, xDelta,yDelta,null);
    }
}
