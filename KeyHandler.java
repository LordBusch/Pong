import java.awt.event.KeyEvent;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.awt.*;

public class KeyHandler implements KeyListener{

    Countdown C = new Countdown();

    public static void wait(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

    public void keyTyped(KeyEvent e) {
        System.out.println("You typed key char:" + e.getKeyChar());
    }
    
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            System.out.println("ENTER START");
            if (Main.GameActive) {
            }
        }
        //int key = e.getKeyCode();
        System.out.println("You pressed key char:" + e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {

        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            System.out.println("ENTER END");
            if (Main.GameActive) {

                C.counter();

                //new Countdown();
                //C.counter();

                /*
                wait(2000);
                //Main.CountdownLabel.setVisible(true);
                Main.CountdownLabel.setText("2");
                Main.frame.repaint();
                wait(2000);
                Main.CountdownLabel.setText("1");
                Main.frame.repaint();
                wait(2000);
                */
                

                //Main.CountdownLabel.setVisible(false);
                //System.out.println("TEST");
                /*
                wait(1000);
                Main.CountdownLabel.setText("2");
                wait(1000);
                Main.CountdownLabel.setText("1");
                wait(1000);
                System.out.println("3 Sec");
                
                wait(3000);
                Main.StartLabel.setVisible(false);
                
                Main.CountdownLabel.setVisible(false);
                wait(1000);
                */
            }
            
        }
        System.out.println("You released key char:" + e.getKeyChar());
    }

    

}