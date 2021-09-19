import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;

public class Countdown {
    
    int timer;
    int count = 3;

    public void counter() {
        
        count = 3;
        timer = count;
        Main.CountdownLabel.setVisible(true);

        Timer TimerA = new Timer();
        TimerTask TaskA = new TimerTask() {
            public void run() {
                
                switch(timer) {
                    case 3: 
                    Main.CountdownLabel.setVisible(true);
                    Main.frame.repaint();
                    break;
                    case 2:
                    Main.CountdownLabel.setText("2");
                    Main.frame.repaint();
                    break;
                    case 1:
                    Main.CountdownLabel.setText("1");
                    Main.frame.repaint();
                    break;
                }
                
                
                if (timer >= 0) {
                    System.out.println("" + timer);
                    timer--;
                }
                if (timer == -1) {
                    TimerA.cancel();
                    Main.CountdownLabel.setVisible(false);
                    Main.StartLabel.setVisible(false);
                }
                

            }
        };
        TimerA.schedule(TaskA, 0, 1000);
    }


}
