import java.awt.event.KeyEvent;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;

public class KeyHandler implements KeyListener{

    Countdown C = new Countdown();
    GameField panGameField = new GameField();

    boolean up1, up2, down1, down2;

    public void draw() {
        //if(Main.GameActive) {
            
                
                if(up1 && GameField.yposracket1 > 0) {
                GameField.yposracket1 = GameField.yposracket1 - 25;
                new GameField();
                panGameField.repaint();
                Main.frame.repaint();
                }
                

                
                if(down1 && GameField.yposracket1 + GameField.heightRacket < Main.PANEL_SIZE_Y) {
                GameField.yposracket1 = GameField.yposracket1 + 25;
                new GameField();
                panGameField.repaint();
                Main.frame.repaint();
                }
                
                

                
                if(up2 && GameField.yposracket2 > 0) {
                GameField.yposracket2 = GameField.yposracket2 - 25;
                new GameField();
                panGameField.repaint();
                Main.frame.repaint();
                }
                


                if(down2 && GameField.yposracket2 + GameField.heightRacket < Main.PANEL_SIZE_Y) {
                GameField.yposracket2 = GameField.yposracket2 + 25;
                new GameField();
                panGameField.repaint();
                Main.frame.repaint();
                }
                
            
        //}
    }

    public void keyTyped(KeyEvent e) {

    }
    
    public void keyPressed(KeyEvent e) {

        if(Main.GameActive) {
            
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                
                case KeyEvent.VK_UP:
                up2 = true;
                break;

                case KeyEvent.VK_DOWN:
                down2 = true;
                break;
                

                case KeyEvent.VK_W:
                up1 = true;
                break;

                case KeyEvent.VK_S:
                down1 = true;
                break;
            }
            
            draw();
        }

    }

    public void keyReleased(KeyEvent e) {

        if (Main.GameActive) {

        
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                
                case KeyEvent.VK_UP:
                up2 = false;
                break;

                case KeyEvent.VK_DOWN:
                down2 = false;
                break;
                

                case KeyEvent.VK_W:
                up1 = false;
                break;

                case KeyEvent.VK_S:
                down1 = false;
                break;
            }


        }


        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            GameField panGameField = new GameField();
            if (Main.CounterActive) {
                C.counter();
            }
        }
    }


    

    

}