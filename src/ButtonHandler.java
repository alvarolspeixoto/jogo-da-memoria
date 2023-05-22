import java.util.HashMap;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ButtonHandler {
	
	private HashMap<Piece,JButton> buttons = new HashMap<>();
	private Color defaultColor = new Color(0xffffff);
	
	
	public boolean checkMatch(JButton b1, JButton b2) {
		return buttonClicked(b1).getContent().equals(buttonClicked(b2).getContent());
	}
	
	public void turnBtn(JButton b) {
		Piece p = buttonClicked(b);
		if(p.getTurned()) {
			b.setIcon(p.getPieceBack());
			p.setTurned("f");
		}
		else {
			b.setIcon(p.getContent());
			p.setTurned("t");
		}
	}
	
	public Piece buttonClicked(JButton b) {
		for(Piece p : buttons.keySet()) {
			if(buttons.get(p).equals(b)) {
				return p;
			}
		}
		return null;
	}
	
	public void addHashMap(Piece p, JButton b) {
		buttons.put(p, b);
	}

	public void formatButton(JButton b) {
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		b.setOpaque(false);
		b.setBorder(emptyBorder);
		b.setFocusable(false);
		b.setBackground(defaultColor);
		b.setVisible(true);
	}
}