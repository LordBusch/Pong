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
    public static boolean BotBool;
    public static boolean BotBoolCalled;
    public static boolean loadBallImgOnce;

    public static JFrame frame;
    public static JPanel MainMenuPanel;
    public static JPanel GameMenuPanel;
    public static JButton StartGameButton;
    public static JButton MainMenuButton;
    public static JButton ExitButton;
    public static JButton GameMenuButton;
    public static JButton BotButton;
    public static JButton RetryButton;
    public static JLabel StartLabel;
    public static JLabel CountdownLabel;
    public static JLabel GameOverLabel;
    public static JLabel ScorePlayer1;
    public static JLabel ScorePlayer2;
    public static JLabel CustomizeGameLabel;
    public static JLabel BotLabel;
    public static JLabel BotActivatedDeactivatedLabel;
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

        GameMenuButton = new JButton("Start");
        GameMenuButton.setBounds(PANEL_SIZE_X / 2 -150, PANEL_SIZE_Y / 3 - 75, 300, 150);
        GameMenuButton.setBackground(Color.white);
        GameMenuButton.setForeground(Color.black);
        GameMenuButton.setFont(fontHeading);
        GameMenuButton.addActionListener(handler);


        ExitButton = new JButton();
        ExitButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 2 + PANEL_SIZE_Y / 4, 300, 150);
        ExitButton.setBackground(Color.white);
        ExitButton.setFont(fontHeading);
        ImageIcon ExitImage = new ImageIcon("Images/ExitIcon.png");
        ExitButton.setIcon(ExitImage);
        ImageIcon ExitRolloverImage = new ImageIcon("Images/ExitIconPressed.png");
        ExitButton.setRolloverIcon(ExitRolloverImage);
        ExitButton.addActionListener(handler);


        //Game Menu
        GameMenuPanel = new JPanel();
        GameMenuPanel.setSize(PANEL_SIZE_X, PANEL_SIZE_Y);
        GameMenuPanel.setBackground(Color.black);
        GameMenuPanel.setLayout(null);

        CustomizeGameLabel = new JLabel("Customize your Game!");
        CustomizeGameLabel.setBounds(PANEL_SIZE_X / 2 - 550, 0, 1100, 150);
        CustomizeGameLabel.setBackground(Color.black);
        CustomizeGameLabel.setForeground(Color.white);
        CustomizeGameLabel.setFont(fontHeading);

        StartGameButton = new JButton("Start");
        StartGameButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 3 - 75, 300, 150);
        StartGameButton.setBackground(Color.white);
        StartGameButton.setForeground(Color.black);
        StartGameButton.setFont(fontHeading);
        StartGameButton.addActionListener(handler);

        BotLabel = new JLabel("Bot (Can´t lose)");
        BotLabel.setBounds(PANEL_SIZE_X / 5 - 80, PANEL_SIZE_Y / 3, 500, 150);
        BotLabel.setBackground(Color.black);
        BotLabel.setForeground(Color.white);
        BotLabel.setFont(fontSubheadings);

        BotButton = new JButton("deactivated");
        BotButton.setBounds(PANEL_SIZE_X / 5 - 150, PANEL_SIZE_Y / 3 + 150, 450, 150);
        BotButton.setBackground(Color.black);
        BotButton.setForeground(Color.white);
        BotButton.setFont(fontSubheadings);
        BotButton.addActionListener(handler);

        BotActivatedDeactivatedLabel = new JLabel("deactivated");
        BotActivatedDeactivatedLabel.setBounds(PANEL_SIZE_X / 5 - 100, PANEL_SIZE_Y / 3 + 300, 300, 150);
        BotActivatedDeactivatedLabel.setBackground(Color.black);
        BotActivatedDeactivatedLabel.setForeground(Color.white);
        BotActivatedDeactivatedLabel.setFont(fontSubheadings);



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
            
        MainMenuPanel.add(GameMenuButton);
        MainMenuPanel.add(ExitButton);

        CountdownLabel = new JLabel("3");
        CountdownLabel.setBounds(PANEL_SIZE_X / 2 - 30, PANEL_SIZE_Y / 8 + 150, 150, 100);
        CountdownLabel.setBackground(Color.black);
        CountdownLabel.setForeground(Color.white);
        CountdownLabel.setFont(fontHeading);
        CountdownLabel.setVisible(false);

        GameOverLabel = new JLabel("GAME OVER");
        GameOverLabel.setFont(fontHeading);
        GameOverLabel.setBounds(PANEL_SIZE_X / 2 - 280, PANEL_SIZE_Y / 2, 600, 100);
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

        GameMenuPanel.add(StartGameButton);
        GameMenuPanel.add(CustomizeGameLabel);
        GameMenuPanel.add(BotLabel);
        GameMenuPanel.add(BotButton);
        //GameMenuPanel.add(BotActivatedDeactivatedLabel)

        RetryButton = new JButton("Retry");
        RetryButton.setBounds(PANEL_SIZE_X / 2 - 150, PANEL_SIZE_Y / 3 + PANEL_SIZE_Y / 3, 300, 150);
        RetryButton.setBackground(Color.black);
        RetryButton.setForeground(Color.white);
        RetryButton.setFont(fontSubheadings);
        RetryButton.addActionListener(handler);
        RetryButton.setVisible(false);

        frame.add(MainMenuPanel);
        frame.repaint();
    }

    

    public static void main(String[] args) {
        new Main();
        new KeyHandler();
    }
}