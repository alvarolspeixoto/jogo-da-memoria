import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Random;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Game implements ActionListener{
	
	GameResult game;
	private ButtonHandler buttonHandler;
	private Stopwatch stopwatch;
	private Board board;
	private boolean firstClick;
	private boolean match;
	private JButton firstButton,secondButton,button1,button2 = new JButton();
	private int score;
	private int pairsMade;
	private int difficulty;
	private Player player;
	JPanel piecePanel;
	JPanel scorePanel;
	private JLabel scoreLabel;
	private ImageIcon background = new ImageIcon(this.getClass().getResource("/gameBackground.gif"));
	private JLabel backgroundLabel;
	private JLabel timerLabel;
	private JFrame frame;
	private Random random;
	private Border border;
	private Font defaultFont;
	private int r,g,b;
	
	
	public Game(int d) {

		buttonHandler = new ButtonHandler();
		stopwatch = new Stopwatch();

		timerLabel = stopwatch.getLabel();

		firstClick = true;
		match = true;
		random = new Random();
		pairsMade = 0;

		difficulty = d;
		player = new Player();
		board = new Board(difficulty);
		
		frame = new JFrame("Memoria");
		piecePanel = new JPanel();
		scorePanel = new JPanel();
		backgroundLabel = new JLabel(background);
		scoreLabel = new JLabel(Integer.toString(score));

		border = BorderFactory.createLineBorder(new Color(0x37155e), 5);
		defaultFont = new Font("Press Start 2P", Font.PLAIN, 40);

		if(difficulty == 1) {
			stopwatch.setElapsedTime(75);
		} else if(difficulty == 2) {
			stopwatch.setElapsedTime(90);
		} else {
			stopwatch.setElapsedTime(100);
		}
		
		new Board(d);
		
		Collection<Piece> pecas = board.getHash().keySet();
		
		scoreLabel.setBounds(50,50,50,50);
		scoreLabel.setFont(defaultFont);
		backgroundLabel.setBounds(0, 0, 800, 800);
		scorePanel.setBounds(690,100,100,100);
		scorePanel.setBorder(border);
		scorePanel.add(scoreLabel);
		
		
		piecePanel.setBorder(border);
		piecePanel.setBounds(50,100,600,600);
		piecePanel.setOpaque(false);
		piecePanel.setLayout(new GridLayout(5,2,10,10));
		
		
		stopwatch.start();
		
		r = random.nextInt(255);
		g = random.nextInt(255);
		b = random.nextInt(255);
		
		for(Piece p : pecas) {
			p.getPieceButton().addActionListener(this);
			p.getPieceButton().setBackground(new Color(r,g,b));
			piecePanel.add(p.getPieceButton());
		}
		
		for(Piece p : board.getListPieces()) {
			buttonHandler.addHashMap(p, p.getPieceButton());
		}
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(830,800);
		frame.setLayout(null);
		frame.add(piecePanel);
		frame.add(scorePanel);
		frame.add(timerLabel);
		frame.add(backgroundLabel);
		frame.setResizable(false);
		frame.setVisible(true);
		
		score = player.getScore();
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int timeLeft = stopwatch.getElapsedTime() / 1000;

		if(firstClick) {
			if(!match) {
				button1 = firstButton;
				button2 = secondButton;
				
				buttonHandler.turnBtn(button1);
				buttonHandler.turnBtn(button2);
			}
			firstButton = (JButton) e.getSource();
			
			button1 = firstButton;
			buttonHandler.turnBtn(button1);

			firstClick = !firstClick;
		}
		
		else {
			secondButton = (JButton) e.getSource();
			button2 = secondButton;
			
			if(secondButton == firstButton) {
				match = false;
			}
			
			
			else {
				buttonHandler.turnBtn(button2);
				if(buttonHandler.checkMatch(button1, button2)) {
					match = true;
					
					button1.setVisible(false);
					button2.setVisible(false);
					score+=2;
					pairsMade++;
					scoreLabel.setText(Integer.toString(score));
				}
				
				else {
					match = false;
				}	
				firstClick = !firstClick;
			}	
		}
		if(win()) {

			if(timeLeft >= 30){
				score *= 1.5;
			} else if(timeLeft >= 20) {
				score *= 1.3;
			} else if(timeLeft >= 10) {
				score *= 1.1;
			}

			game = new VictoryScreen(score, timeLeft);
			game.show();
			frame.setVisible(false);

		} else if(stopwatch.getElapsedTime() == 0) {
			game = new DefeatScreen(score, timeLeft);
			game.show();
			frame.setVisible(false);
		}
		
	}
	
	public boolean win() {
		return (pairsMade == board.getPieceAmount()/2);
	}
}
