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

    public static JFrame frame;
    public static JPanel MainMenuPanel;
    public static JButton StartGameButton;
    public static JButton MainMenuButton;
    public static JButton ExitButton;
    public static JLabel StartLabel;
    public static JLabel CountdownLabel;
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


        StartLabel = new JLabel("Press `Enter´ to start");
        StartLabel.setBounds(PANEL_SIZE_X / 2 - 500, PANEL_SIZE_Y / 2 - 50, 1000, 100);
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
        CountdownLabel.setBounds(PANEL_SIZE_X / 2 - 75, PANEL_SIZE_Y / 2 + 100, 150, 100);
        CountdownLabel.setBackground(Color.black);
        CountdownLabel.setForeground(Color.white);
        CountdownLabel.setFont(fontHeading);
        CountdownLabel.setVisible(false);

        frame.add(MainMenuPanel);
        frame.repaint();
    }

    

    public static void main(String[] args) {
        new Main();
        new KeyHandler();
    }
}