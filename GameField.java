import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.Toolkit;
import java.awt.*;



public class GameField extends JPanel{

    public static int heightRacket = 250;
    public static int widthRacket = 50;

    public static int xposracket1 = 50;
    public static int yposracket1;

    public static int xposracket2 = Main.PANEL_SIZE_X - 100;
    public static int yposracket2 = Main.PANEL_SIZE_Y / 2 - 100;

    GameField() {
        this.setSize(Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(Color.black);
        this.setOpaque(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (Main.GameActive | Main.CounterActive) {
            DrawRacket(g);
        }
    }

   

    public void DrawRacket(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(xposracket1, yposracket1, widthRacket, heightRacket);
        g.fillRect(xposracket2, yposracket2, widthRacket, heightRacket);
    }
    

}