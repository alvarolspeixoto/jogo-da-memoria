
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Board {
	
	private ImageCompressor imageCompressor;
	private int pieceAmount;
	private List<Piece> myPieces;
	private ImageIcon[] myIcons;
	private HashMap<Piece,JButton> buttons;
	private int difficulty;
	
	
	public Board(int d) {

		difficulty = d;
		
		if(difficulty==1) {
			pieceAmount = 20;
		}
		
		if(difficulty==2) {
			pieceAmount = 30;
		}
		
		if(difficulty==3) {
			pieceAmount = 40;
		}
		
		imageCompressor = new ImageCompressor();

		myPieces = new ArrayList<>();
		myIcons = new ImageIcon[21];
		buttons = new HashMap<>();
		
		myIcons[0] = new ImageIcon(this.getClass().getResource("/emoji1.png"));
		myIcons[1] = new ImageIcon(this.getClass().getResource("/emoji2.png"));
		myIcons[2] = new ImageIcon(this.getClass().getResource("/emoji3.png"));
		myIcons[3] = new ImageIcon(this.getClass().getResource("/emoji4.png"));
		myIcons[4] = new ImageIcon(this.getClass().getResource("/emoji5.png"));
		myIcons[5] = new ImageIcon(this.getClass().getResource("/emoji6.png"));
		myIcons[6] = new ImageIcon(this.getClass().getResource("/emoji7.png"));
		myIcons[7] = new ImageIcon(this.getClass().getResource("/emoji8.png"));
		myIcons[8] = new ImageIcon(this.getClass().getResource("/emoji9.png"));
		myIcons[9] = new ImageIcon(this.getClass().getResource("/emoji10.png"));
		myIcons[10] = new ImageIcon(this.getClass().getResource("/emoji11.png"));
		myIcons[11] = new ImageIcon(this.getClass().getResource("/emoji12.png"));
		myIcons[12] = new ImageIcon(this.getClass().getResource("/emoji13.png"));
		myIcons[13] = new ImageIcon(this.getClass().getResource("/emoji14.png"));
		myIcons[14] = new ImageIcon(this.getClass().getResource("/emoji15.png"));
		myIcons[15] = new ImageIcon(this.getClass().getResource("/emoji16.png"));
		myIcons[16] = new ImageIcon(this.getClass().getResource("/emoji17.png"));
		myIcons[17] = new ImageIcon(this.getClass().getResource("/emoji18.png"));
		myIcons[18] = new ImageIcon(this.getClass().getResource("/emoji19.png"));
		myIcons[19] = new ImageIcon(this.getClass().getResource("/emoji20.png"));
		myIcons[20] = new ImageIcon(this.getClass().getResource("/carta.png"));
		
		
		newIcons(myIcons, difficulty);
		
		for(int i = 0; i < pieceAmount/2; i++) {
			myPieces.add(new Piece(myIcons[i],myIcons[myIcons.length-1])); 
			myPieces.add(new Piece(myIcons[i],myIcons[myIcons.length-1]));
		}
		
		Collections.shuffle(myPieces);
		
		for(Piece p : myPieces) {
			buttons.put(p, new JButton(p.getPieceBack()));
		}
	}
	
	private void newIcons(ImageIcon[] ar, int d) {
		int width;
		int height;
		if(d==1) {
			width = 141;
			height = 110;
		}
		else if(d==2) {
			width = 90;
			height= 110;
		}
		else {
			width = 65;
			height = 110;
		}
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = (ImageIcon) imageCompressor.resizeIcon(ar[i],width,height);
		}
	}
	
	public int getPieceAmount() {
		return pieceAmount;
	}
	
	public List<Piece> getListPieces() {
		return myPieces;
	}
	
	public HashMap<Piece,JButton> getHash() {
		return buttons;
	}
}