import javax.swing.Icon;
import javax.swing.JButton;

public class Piece {
	
	private JButton button;
	private Icon pieceBack; 
	private Icon content;
	private boolean turned = false;
	
	public Piece(Icon content, Icon pieceBack){
		this.content = content;
		this.pieceBack = pieceBack;
		button = new JButton(pieceBack);
	}

	public Icon getContent() {
		return content;
	}
	
	public Icon getPieceBack() {
		return pieceBack;
	}

	public boolean getTurned() {
		return turned;
	}
	
	public void setTurned(String s) {
		if(s.equals("t")) {
			turned = true;
		}
		else {
			turned = false;
		}
	}
	
	public JButton getPieceButton() {
		return button;
	}
}
