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
            
                
                if(up1) {
                GameField.yposracket1 = GameField.yposracket1 - 15;
                new GameField();
                panGameField.repaint();
                Main.frame.repaint();
                }
                

                
                if(down1) {
                GameField.yposracket1 = GameField.yposracket1 + 15;
                new GameField();
                panGameField.repaint();
                Main.frame.repaint();
                }
                
                

                
                if(up2) {
                GameField.yposracket2 = GameField.yposracket2 - 15;
                new GameField();
                panGameField.repaint();
                Main.frame.repaint();
                }
                


                if(down2) {
                GameField.yposracket2 = GameField.yposracket2 + 15;
                new GameField();
                panGameField.repaint();
                Main.frame.repaint();
                }
                
            
        //}
    }

    public void keyTyped(KeyEvent e) {

        
        //System.out.println("You typed key char:" + e.getKeyChar());
    }
    
    public void keyPressed(KeyEvent e) {

        if(Main.GameActive) {
            
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                
                case KeyEvent.VK_UP:
                up1 = true;
                break;

                case KeyEvent.VK_DOWN:
                down1 = true;
                break;
                

                case KeyEvent.VK_W:
                up2 = true;
                break;

                case KeyEvent.VK_S:
                down2 = true;
                break;
            }
            
            draw();
        }

        
        //int key = e.getKeyCode();
        System.out.println("You pressed key char:" + e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {

        if (Main.GameActive) {

        
            int keyCode = e.getKeyCode();
            switch(keyCode) {
                
                case KeyEvent.VK_UP:
                up1 = false;
                break;

                case KeyEvent.VK_DOWN:
                down1 = false;
                break;
                

                case KeyEvent.VK_W:
                up2 = false;
                break;

                case KeyEvent.VK_S:
                down2 = false;
                break;
            }


        }


        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            if (Main.CounterActive) {
                C.counter();
            }
        }
        System.out.println("You released key char:" + e.getKeyChar());
    }


    

    

}