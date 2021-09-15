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

        System.out.println("Action performed");
		JFrame frame = Main.frame;
        JPanel panGameField = Main.panGameField;
        
        if(e.getSource() == Main.StartGameButton) {
            System.out.println("Starting");
            Main.Start = true;

            panGameField.add(Main.StartLabel);
            panGameField.add(Main.MainMenuButton);
            panGameField.setVisible(true);

            frame.remove(Main.MainMenuPanel);
            Main.MainMenuPanel.setVisible(false);
            frame.add(panGameField);
            frame.setVisible(true);
            frame.repaint();
           
        }
        


        if(e.getSource() == Main.ExitButton) {
            System.exit(0);
        }

        if(e.getSource() == Main.MainMenuButton) {
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