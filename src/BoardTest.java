import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;

import org.junit.Test;

public class BoardTest {
    
    Board board = new Board(1);

    @Test
    public void testGetHash() {
        HashMap<Piece,JButton> testHash = new HashMap<>();
        assertFalse(testHash == board.getHash());
    }

    @Test
    public void testGetListPieces() {
        List<Piece> testList = new ArrayList<>();
        Piece testPiece = new Piece(null, null);
        testList.add(testPiece);
        assertFalse(testList == board.getListPieces());
    }

    @Test
    public void testGetPieceAmount() {
        assertEquals(20, board.getPieceAmount());
    }
}
