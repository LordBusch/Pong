import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

    public static int PANEL_SIZE_X = 1920;
    public static int PANEL_SIZE_Y = 1080;
    public static boolean Start = false;
    public static boolean CounterActive = false;
    public static boolean GameActive = false;
    public static boolean drawHelpLines;

    public static JFrame frame;
    public static JPanel MainMenuPanel;
    public static JButton StartGameButton;
    public static JButton MainMenuButton;
    public static JButton ExitButton;
    public static JLabel StartLabel;
    public static JLabel CountdownLabel;
    public static JLabel GameOverLabel;
    public static JLabel ScorePlayer1;
    public static JLabel ScorePlayer2;
    public static ActionHandler handler;

    Font fontHeading = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 12);
	Font fontSubheadings = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 30);
    Font fontsizelittle = new Font("Verdana", Font.PLAIN, PANEL_SIZE_Y / 50);

    public Main() {
        gui();
    }

    



    public void gui(){

        handler = new ActionHandler();
        KeyHandler khandler = new KeyHandler();

        frame = new JFrame("Pong");
        frame.setBounds(0, 0, PANEL_SIZE_X, PANEL_SIZE_Y);
        frame.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
        frame.setBackground(Color.RED);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(frame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        ImageIcon image = new ImageIcon("Images/Pong-App-Icon.png");
		frame.setIconImage(image.getImage());
        frame.addKeyListener(khandler);
        frame.setFocusable(true);
        frame.setUndecorated(true);
        frame.setVisible(true);

        //Main Menu
        MainMenuPanel = new JPanel();
        MainMenuPanel.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
        MainMenuPanel.setBackground(Color.black);
        MainMenuPanel.setLayout(null);
        MainMenuPanel.addKeyListener(khandler);

        StartGameButton = new JButton("Start");
        StartGameButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 3 - 75, 300, 150);
        StartGameButton.setBackground(Color.white);
        StartGameButton.setForeground(Color.black);
        StartGameButton.setFont(fontHeading);
        StartGameButton.addActionListener(handler);


        ExitButton = new JButton();
        ExitButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 2 + PANEL_SIZE_Y / 4, 300, 150);
        ExitButton.setBackground(Color.white);
        ExitButton.setFont(fontHeading);
        ImageIcon ExitImage = new ImageIcon("Images/ExitIcon.png");
        ExitButton.setIcon(ExitImage);
        ImageIcon ExitRolloverImage = new ImageIcon("Images/ExitIconPressed.png");
        ExitButton.setRolloverIcon(ExitRolloverImage);
        ExitButton.addActionListener(handler);


        //GameField
        StartLabel = new JLabel("Press `Enter´ to start");
        StartLabel.setBounds(PANEL_SIZE_X / 2 - 500, PANEL_SIZE_Y / 8, 1000, 100);
        StartLabel.setBackground(Color.black);
        StartLabel.setForeground(Color.white);
        StartLabel.setFont(fontHeading);
        
        MainMenuButton = new JButton("Main Menu");
        MainMenuButton.setBounds(PANEL_SIZE_X / 2 - 75, 0, 150, 50);
        MainMenuButton.setBackground(Color.black);
        MainMenuButton.setForeground(Color.white);
        MainMenuButton.setFont(fontsizelittle);
        MainMenuButton.addActionListener(handler);
        MainMenuButton.setVisible(true);
            
        MainMenuPanel.add(StartGameButton);
        MainMenuPanel.add(ExitButton);

        CountdownLabel = new JLabel("3");
        CountdownLabel.setBounds(PANEL_SIZE_X / 2 - 30, PANEL_SIZE_Y / 8 + 150, 150, 100);
        CountdownLabel.setBackground(Color.black);
        CountdownLabel.setForeground(Color.white);
        CountdownLabel.setFont(fontHeading);
        CountdownLabel.setVisible(false);

        GameOverLabel = new JLabel("GAME OVER");
        GameOverLabel.setFont(fontHeading);
        GameOverLabel.setBounds(PANEL_SIZE_X / 2 - 300, PANEL_SIZE_Y / 2, 600, 100);
        GameOverLabel.setBackground(Color.black);
        GameOverLabel.setForeground(Color.white);
        GameOverLabel.setVisible(false);

        ScorePlayer1 = new JLabel("0");
        ScorePlayer1.setFont(fontSubheadings);
        ScorePlayer1.setBounds(PANEL_SIZE_X / 2 - 125, 0, 50, 50);
        ScorePlayer1.setBackground(Color.black);
        ScorePlayer1.setForeground(Color.red);

        ScorePlayer2 = new JLabel("0");
        ScorePlayer2.setFont(fontSubheadings);
        ScorePlayer2.setBounds(PANEL_SIZE_X / 2 + 100, 0, 50, 50);
        ScorePlayer2.setBackground(Color.black);
        ScorePlayer2.setForeground(Color.red);

        frame.add(MainMenuPanel);
        frame.repaint();
    }

    

    public static void main(String[] args) {
        new Main();
        new KeyHandler();
    }
}