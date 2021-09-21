import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.Integer;


public class ActionHandler implements ActionListener {

    


    public void actionPerformed(ActionEvent e) {
        new KeyHandler();

        System.out.println("Action performed");
		JFrame frame = Main.frame;
        GameField panGameField = new GameField();
        
        
        if(e.getSource() == Main.StartGameButton) {

            GameField.yposracket1 = Main.PANEL_SIZE_Y / 2 - 100;
            GameField.yposracket2 = Main.PANEL_SIZE_Y / 2 - 100;
            
            System.out.println("Starting");
            Main.Start = true;
            Main.CounterActive = true;
            Main.StartLabel.setVisible(true);
            Main.CountdownLabel.setText("3");

            
            panGameField.add(Main.StartLabel);
            panGameField.add(Main.MainMenuButton);
            panGameField.add(Main.CountdownLabel);
            
            panGameField.setVisible(true);

            frame.remove(Main.MainMenuPanel);
            Main.MainMenuPanel.setVisible(false);
            frame.add(panGameField);
            frame.repaint();
            new KeyHandler();
            
        }
        


        if(e.getSource() == Main.ExitButton) {
            System.exit(0);
        }

        if(e.getSource() == Main.MainMenuButton) {
            
            Main.GameActive = false;
            Main.Start = false;
            frame.remove(panGameField);
			panGameField.setVisible(false);
			frame.getContentPane().removeAll();

			frame.add(Main.MainMenuPanel);
			Main.MainMenuPanel.setVisible(true);
			frame.repaint();
			frame.setVisible(true);
            
        }

    }
}