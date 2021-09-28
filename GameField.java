import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.Toolkit;
import java.awt.*;



public class GameField extends JPanel{

    public static int heightRacket = 250;
    public static int widthRacket = 50;
    public static int radiusBall = 75;

    public static int xposracket1 = 50;
    public static int yposracket1;
    public static int xposracket2 = Main.PANEL_SIZE_X - 100;
    public static int yposracket2 = Main.PANEL_SIZE_Y / 2 - 100;

    public static int xposball = Main.PANEL_SIZE_X / 2 - 75;
    public static int yposball = Main.PANEL_SIZE_Y / 2 - 75;

    public static double directionBallDouble;
    public static int directionBall;
    public static int ValueScore1;
    public static int ValueScore2;
    public static String ValueScore1String;
    public static String ValueScore2String;

    public static boolean RightUp;
    public static boolean RightDown;
    public static boolean LeftUp;
    public static boolean Leftdown;

    GameField() {
        this.setSize(Main.PANEL_SIZE_X, Main.PANEL_SIZE_Y);
        this.setVisible(true);
        this.setLayout(null);
        this.setBackground(Color.black);
        this.setOpaque(true);


    }

    //Create method for delay
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


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
        if (Main.drawHelpLines) {
            drawHelpLinesVoid(g);
        }
        */
        if (Main.GameActive | Main.CounterActive) {
            DrawRacket(g);
            DrawBall(g);
            Score();
            wait(1);
            MoveBotRacket();
        }
    }


    public void DrawRacket(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(xposracket1, yposracket1, widthRacket, heightRacket);
        g.fillRect(xposracket2, yposracket2, widthRacket, heightRacket);
    }

    public void CalculateBallDirection() {
        if (Main.drawHelpLines) {
            Leftdown = false;
            LeftUp = false;
            RightDown = false;
            RightUp = false;
            directionBallDouble = Math.random();
            System.out.println(directionBallDouble);
            if (directionBallDouble < 0.25) {
                Leftdown = true;
            }
            if (directionBallDouble > 0.25 && directionBallDouble < 0.5) {
                LeftUp = true;
            }
            if (directionBallDouble > 0.5 && directionBallDouble < 0.75) {
                RightDown = true;
            }
            if(directionBallDouble > 0.75) {
                RightUp = true;
            }
        }


        
    }

    public void DrawBall(Graphics g) {

        

        if(Main.GameActive) {
            if (RightDown) {
                xposball++;
                yposball++;
            }
            if (Leftdown) {
                xposball--;
                yposball++;
            }
            if (LeftUp) {
                xposball--;
                yposball--;
            }
            if(RightUp) {
                xposball++;
                yposball--;
            }
            g.setColor(Color.white);
            g.fillOval(xposball, yposball, radiusBall * 2, radiusBall * 2);
            /*
            //paint Ball Icon
            if (Main.loadBallImgOnce == false) {
                ImageIcon BallIcon = new ImageIcon("Images/Pong-Ball-Icon.png");
                Image BallImg = BallIcon.getImage();
                Image resizedBallImg = BallImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
                ImageIcon scaledBallImg = new ImageIcon(resizedBallImg);
                BufferedImage bi = new BufferedImage(
                scaledBallImg.getIconWidth(),
                scaledBallImg.getIconHeight(),
                BufferedImage.TYPE_INT_RGB);
                Main.loadBallImgOnce = true;
            }
            

            scaledBallImg.paintIcon(null, g, xposball, yposball);
            */
            //System.out.println(xposball);
            //System.out.println(yposball);
            Main.frame.repaint();
        }
        if(RightDown && yposball + radiusBall * 2 > 1080 | xposball + radiusBall * 2 > 1920) {
            RightDown = false;
            RightUp = true;
        }
        if(Leftdown && yposball + radiusBall * 2 > 1080 | xposball < 0) {
            Leftdown = false;
            LeftUp = true;
            
        }
        if(LeftUp && yposball < 0 | xposball < 0) {
            LeftUp = false;
            Leftdown = true;
            
        }
        if(RightUp && yposball < 0 | xposball + radiusBall * 2 > 1920) {
            RightUp = false;
            RightDown = true;
           
        }


        //Check, if racket is touching ball
        if (Leftdown) {
            if(xposball < xposracket1 + widthRacket && yposball + radiusBall > yposracket1 && yposball + radiusBall < yposracket1 + heightRacket) {
                RightDown = true;
                Leftdown = false;
                ValueScore1++;
            }
        }
        if (LeftUp) {
            if(xposball < xposracket1 + widthRacket && yposball + radiusBall > yposracket1 && yposball + radiusBall < yposracket1 + heightRacket) {
                RightUp = true;
                LeftUp = false;
                ValueScore1++;
            }
        }
        if (RightDown) {
            if (xposball + radiusBall * 2 > xposracket2 && yposball + radiusBall > yposracket2 && yposball + radiusBall < yposracket2 + heightRacket) {
                Leftdown = true;
                RightDown = false;
                ValueScore2++;
            }
        }
        if (RightUp) {
            if (xposball + radiusBall * 2 > xposracket2 && yposball + radiusBall > yposracket2 && yposball + radiusBall < yposracket2 + heightRacket) {
                LeftUp = true;
                RightUp = false;
                ValueScore2++;
            }
        }
            

        //Check, if ball is behind racket
        if (xposball < 90) {
            RightUp = false;
            RightDown = false;
            LeftUp = false;
            Leftdown = false;
            Main.GameOverLabel.setVisible(true);
            Main.RetryButton.setVisible(true);
        }
        if (xposball > Main.PANEL_SIZE_X - 90) {
            RightUp = false;
            RightDown = false;
            LeftUp = false;
            Leftdown = false;
            Main.GameOverLabel.setVisible(true);
            Main.RetryButton.setVisible(true);
        }
    }

    public void Score() {
        ValueScore1String = "" + ValueScore1;
		Main.ScorePlayer1.setText(ValueScore1String);

        ValueScore2String = "" + ValueScore2;
		Main.ScorePlayer2.setText(ValueScore2String);
    }

    public void MoveBotRacket() {
        if (Main.BotBool) {
            GameField.yposracket1 = GameField.yposball - 125;
        }
    }

    /*
    public void drawHelpLinesVoid(Graphics g) {
        if (Main.drawHelpLines) {
            System.out.println("Drew HelpLine");
            if (RightDown) {
                g.drawLine(xposball + 75, yposball + 75, 1500, 1080);
            }
            if (Leftdown) {
                g.drawLine(xposball + 75, yposball + 75, 420, 1080);
            }
            if (LeftUp) {
                g.drawLine(xposball + 75, yposball + 75, 420, 0);
            }
            if(RightUp) {
                g.drawLine(xposball + 75, yposball + 75, 1500, 0);
            }
            Main.drawHelpLines = false;
        }
    }
    */

}