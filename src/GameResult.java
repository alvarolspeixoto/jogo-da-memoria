import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameResult implements ActionListener {

    protected ButtonHandler buttonHandler;
    protected JFrame frame;
    protected JPanel buttonsPanel;
    protected JPanel scorePanel;
    protected JLabel scoreLabel;
    protected JLabel resultLabel;
    
    protected ImageIcon restartImg = new ImageIcon(this.getClass().getResource("/restartButton.gif"));
    protected ImageIcon quitImg = new ImageIcon(this.getClass().getResource("/quitButton.png"));

    protected JButton restart = new JButton(restartImg);
    protected JButton quit = new JButton(quitImg);

    protected Font font;
    
    public GameResult(int score, int timeLeft) {
    	
        buttonHandler = new ButtonHandler();

        buttonHandler.formatButton(restart);
        buttonHandler.formatButton(quit);

    	frame = new JFrame("Resultado do jogo");
    	buttonsPanel = new JPanel();      
        scorePanel = new JPanel();
        scoreLabel = new JLabel();
        
        resultLabel = new JLabel();
        font = new Font("Press Start 2P", Font.PLAIN, 20);

        scorePanel.setBounds(0,330,600,100);
        scorePanel.add(scoreLabel);
        scorePanel.setOpaque(false);
        scorePanel.setVisible(true);
        scorePanel.setLayout(new GridLayout(2,1,10,10));

        scoreLabel.setText("Score: " + score);
        scoreLabel.setFont(font);
        scoreLabel.setHorizontalTextPosition(JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setForeground(Color.green);
        scoreLabel.setVisible(true);
        scoreLabel.setBounds(0, 80, 600, 200);

        

        resultLabel.setFont(font);
        resultLabel.setBounds(60,50,500,400);
        resultLabel.setHorizontalTextPosition(JLabel.CENTER);
        resultLabel.setVerticalTextPosition(JLabel.TOP);
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        
        restart.addActionListener(this);
        quit.addActionListener(this);

        buttonsPanel.setBackground(Color.black);
        buttonsPanel.setBounds(0,420,600,120);
		
        buttonsPanel.setOpaque(false);
		buttonsPanel.setLayout(new GridLayout(2,1,10,10));
        buttonsPanel.setVisible(true);
        buttonsPanel.add(restart);
        buttonsPanel.add(quit);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.black);
        frame.add(scorePanel);
		frame.add(resultLabel);
		frame.add(buttonsPanel);
        frame.setResizable(false);
		frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        if(button == quit) {
            System.exit(0);
        } else if(button == restart) {
            frame.setVisible(false);
            new Menu();    
        }   
    }

    public void show() {

    }
}
