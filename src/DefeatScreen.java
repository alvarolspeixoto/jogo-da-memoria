import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DefeatScreen extends GameResult{

	JLabel gameOverLabel = new JLabel();
	ImageIcon gameOverGif = new ImageIcon(this.getClass().getResource("/gameOver.gif"));
	
	private ImageIcon sadImg;
	
	public DefeatScreen(int score, int timeLeft) {

		super(score, timeLeft);
	}

	@Override
	public void show() {
		gameOverLabel.setBounds(0,0,600,100);
		gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
		
		gameOverLabel.setIcon(gameOverGif);
		sadImg = new ImageIcon(this.getClass().getResource("/cry.gif"));
		frame.add(gameOverLabel);	
		
		resultLabel.setIcon(sadImg);
	}
}
