import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;


public class VictoryScreen extends GameResult {

	private ImageIcon happyImg; 
	private ImageIcon backgroundImg = new ImageIcon(this.getClass().getResource("/winBackground.gif"));
	
	private JLabel backgroundLabel = new JLabel(backgroundImg);
	private JLabel bonusLabel;
	private int timeLeft;
	
	public VictoryScreen(int score, int timeLeft) {
		super(score, timeLeft);
		this.timeLeft = timeLeft;

	}

	@Override
	public void show() {

		happyImg = new ImageIcon(this.getClass().getResource("/win.gif"));
		bonusLabel = new JLabel();
		
		backgroundLabel.setBounds(0,0,600,600);

		bonusLabel.setFont(font = new Font("Press Start 2P", Font.PLAIN, 10));
        bonusLabel.setHorizontalTextPosition(JLabel.CENTER);
        bonusLabel.setHorizontalAlignment(JLabel.CENTER);
        bonusLabel.setForeground(new Color(0xe1fa00));
        bonusLabel.setVisible(true);
        bonusLabel.setBounds(0, 0, 600, 100);

		if(timeLeft >= 30){
            bonusLabel.setText("Tempo restante: " + timeLeft + "s - Bônus de pontuação 1.5x");
        } else if(timeLeft >= 20) {
            bonusLabel.setText("Tempo restante: " + timeLeft + "s - Bônus de pontuação 1.3x");
        } else if(timeLeft >= 10) {
            bonusLabel.setText("Tempo restante: " + timeLeft + "s - Bônus de pontuação 1.1x");
        } else {
            bonusLabel.setText("Tempo restante: " + timeLeft + "s - Sem bônus de pontuação");
        }

		scorePanel.add(bonusLabel);
		frame.add(backgroundLabel);
		resultLabel.setIcon(happyImg);
		restart.setVisible(true);
		quit.setVisible(true);
	}
	public static void main(String[] args) {
		GameResult game = new VictoryScreen(10, 10);
		game.show();
	}
}
