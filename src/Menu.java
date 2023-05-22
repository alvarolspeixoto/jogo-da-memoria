import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Menu implements ActionListener {
	
	ButtonHandler btnHandler = new ButtonHandler();

	private JButton start;
	private JButton quit;
	private JButton easy;
	private JButton medium;
	private JButton hard;

	
	private JButton chosenDifficulty;

	private int difficulty;

	private Color pressedColor = new Color(0xb4b8bf);
	private Color defaultColor = new Color(0xffffff);
	Font defaultFont = new Font("Press Start 2P", Font.PLAIN, 20);
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	private ImageIcon backgroundImg = new ImageIcon(this.getClass().getResource("/background.gif"));
	private ImageIcon startImg = new ImageIcon(this.getClass().getResource("/startgif.gif"));
	private ImageIcon easyImg = new ImageIcon(this.getClass().getResource("/easyButton.png"));
	private ImageIcon mediumImg = new ImageIcon(this.getClass().getResource("/mediumButton.png"));
	private ImageIcon hardImg = new ImageIcon(this.getClass().getResource("/hardButton.png"));
	private ImageIcon quitImg = new ImageIcon(this.getClass().getResource("/quitButton.png"));
	

	private JFrame frame;
	private JLabel warning;
	private JLabel backgroundLabel = new JLabel(backgroundImg);
	private JPanel difficultyPanel;
	private JPanel optionsPanel;	
	
	
	
	public Menu() {

		frame = new JFrame("Menu");
		difficultyPanel = new JPanel();
		optionsPanel = new JPanel();
		
		
		easy = new JButton(easyImg);
		medium = new JButton(mediumImg);
		hard = new JButton(hardImg);
		start = new JButton(startImg);
		quit = new JButton(quitImg);

		quit.addActionListener(this);
		start.addActionListener(this);
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);

		btnHandler.formatButton(easy);
		btnHandler.formatButton(medium);
		btnHandler.formatButton(hard);
		btnHandler.formatButton(start);
		btnHandler.formatButton(quit);
		
		optionsPanel.add(start);
		optionsPanel.add(quit);
		optionsPanel.setOpaque(false);
		optionsPanel.setBackground(new Color((0x0f0000)));
		
		backgroundLabel.setBounds(0,0,600,600);
		backgroundLabel.setVisible(true);

		optionsPanel.setBounds(180,400,200,150);
		optionsPanel.setVisible(true);
		optionsPanel.setLayout(new GridLayout(2,1,10,10));
		
		difficultyPanel.add(easy);
		difficultyPanel.add(medium);
		difficultyPanel.add(hard);
		
		difficultyPanel.setBounds(5,75,575,100);
		difficultyPanel.setLayout(new GridLayout(1,1,3,5));
		difficultyPanel.setOpaque(false);
		difficultyPanel.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);

		warning = new JLabel("Escolha a dificuldade!");
		warning.setBounds(0,0,600,350);
		warning.setForeground(Color.white);
		warning.setFont(defaultFont);				
		warning.setHorizontalAlignment(JLabel.CENTER);
		warning.setVerticalAlignment(JLabel.BOTTOM);
		frame.add(warning);
		warning.setVisible(false);
		
		
		frame.add(difficultyPanel);
		frame.add(optionsPanel);
		frame.add(backgroundLabel);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		
		if(button==quit) {
			System.exit(0);
		}
		
		if(button==easy) {
			if(chosenDifficulty != null) {
				chosenDifficulty.setBackground(defaultColor);
				chosenDifficulty.setOpaque(false);
			}
			chosenDifficulty = easy;
			difficulty = 1;
			easy.setBackground(pressedColor);
			easy.setOpaque(true);

		}
		
		if(button==medium) {
			if(chosenDifficulty != null) {
				chosenDifficulty.setBackground(defaultColor);
				chosenDifficulty.setOpaque(false);
			}
			chosenDifficulty = medium;
			difficulty = 2;
			medium.setBackground(pressedColor);
			medium.setOpaque(true);
		}
		
		if(button==hard) {
			if(chosenDifficulty != null) {
				chosenDifficulty.setBackground(defaultColor);
				chosenDifficulty.setOpaque(false);
			}
			chosenDifficulty = hard;
			difficulty = 3;
			hard.setBackground(pressedColor);
			hard.setOpaque(true);
			
		}
		if(button==start) {
			if(chosenDifficulty == null) {
				warning.setVisible(true);
			} else {
				new Game(difficulty);
				frame.setVisible(false);
			}
		}
	}
}
