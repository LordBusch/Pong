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

            Main.drawHelpLines = true;

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
            panGameField.add(Main.GameOverLabel);
            panGameField.add(Main.ScorePlayer1);
            panGameField.add(Main.ScorePlayer2);
            panGameField.add(Main.RetryButton);

            //panGameField.CalculateBall();
            
            panGameField.setVisible(true);

            frame.remove(Main.GameMenuPanel);
            Main.MainMenuPanel.setVisible(false);
            frame.add(panGameField);
            frame.repaint();
            new KeyHandler();
            
        }
        


        if(e.getSource() == Main.ExitButton) {
            System.exit(0);
        }

        if(e.getSource() == Main.MainMenuButton) {
            Main.drawHelpLines = true;
            Main.GameActive = false;
            Main.Start = false;
            frame.remove(panGameField);
			panGameField.setVisible(false);
			frame.getContentPane().removeAll();

            Main.GameOverLabel.setVisible(false);

			frame.add(Main.MainMenuPanel);
			Main.MainMenuPanel.setVisible(true);
			frame.repaint();
			frame.setVisible(true);

            GameField.xposball = Main.PANEL_SIZE_X / 2 - 75;
            GameField.yposball = Main.PANEL_SIZE_Y / 2 - 75;

            GameField.ValueScore1 = 0;
            GameField.ValueScore2 = 0;
            
        }

        if(e.getSource() == Main.GameMenuButton) {
            frame.remove(Main.MainMenuPanel);
            frame.add(Main.GameMenuPanel);
            frame.repaint();
        }

        if(e.getSource() == Main.BotButton) {
            if (Main.BotBool && Main.BotBoolCalled == false) {
                Main.BotBool = false;
                Main.BotButton.setText("deactivated");
                System.out.println("deactivated");
                Main.BotBoolCalled = true;
            }
            if (Main.BotBool == false && Main.BotBoolCalled == false) {
                Main.BotBool = true;
                Main.BotButton.setText("activated");
                System.out.println("activated");
                Main.BotBoolCalled = true;
            }
            Main.BotBoolCalled = false;
        }

        if(e.getSource() == Main.RetryButton) {
            /*
            Main.drawHelpLines = true;

            GameField.yposracket1 = Main.PANEL_SIZE_Y / 2 - 100;
            GameField.yposracket2 = Main.PANEL_SIZE_Y / 2 - 100;
            
            System.out.println("Starting");
            Main.Start = true;
            Main.CounterActive = true;
            Main.CountdownLabel.setText("3");

            Main.GameOverLabel.setVisible(false);
            Main.RetryButton.setVisible(false);
            */

            Main.drawHelpLines = true;
            Main.GameActive = false;
            Main.Start = false;
            frame.remove(panGameField);
			panGameField.setVisible(false);
			frame.getContentPane().removeAll();

            Main.GameOverLabel.setVisible(false);
            Main.RetryButton.setVisible(false);
			frame.repaint();
			frame.setVisible(true);

            GameField.xposball = Main.PANEL_SIZE_X / 2 - 75;
            GameField.yposball = Main.PANEL_SIZE_Y / 2 - 75;

            GameField.ValueScore1 = 0;
            GameField.ValueScore2 = 0;




            Main.drawHelpLines = true;

            GameField.yposracket1 = Main.PANEL_SIZE_Y / 2 - 100;
            GameField.yposracket2 = Main.PANEL_SIZE_Y / 2 - 100;
            
            System.out.println("Starting");
            Main.Start = true;
            Main.CounterActive = true;
            Main.StartLabel.setVisible(true);
            Main.CountdownLabel.setText("3");

            //panGameField.removeAll();
            
            panGameField.add(Main.StartLabel);
            panGameField.add(Main.MainMenuButton);
            panGameField.add(Main.CountdownLabel);
            panGameField.add(Main.GameOverLabel);
            panGameField.add(Main.ScorePlayer1);
            panGameField.add(Main.ScorePlayer2);
            panGameField.add(Main.RetryButton);

            //panGameField.CalculateBall();
            
            panGameField.setVisible(true);

            frame.getContentPane().removeAll();
            frame.remove(panGameField);
            frame.add(panGameField);
            frame.repaint();
            new KeyHandler();
        }

    }
}