import javax.swing.ImageIcon;
import javax.swing.JButton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PieceTest {

    ImageIcon content = new ImageIcon();
    ImageIcon back = new ImageIcon();
    Piece piece = new Piece(content,back);

    @Test
    public void testGetContent() {
        assertEquals(content, piece.getContent());
    }

    @Test
    public void testGetPieceBack() {
        assertEquals(back, piece.getPieceBack());
    }

    @Test
    public void testGetPieceButton() {
        JButton button = new JButton();
        assertFalse(button == piece.getPieceButton());
    }

    @Test
    public void testGetTurned() {
        assertEquals(false, piece.getTurned());
    }

    @Test
    public void testSetTurned() {
        piece.setTurned("t");
        assertEquals(true, piece.getTurned());
    }
}
