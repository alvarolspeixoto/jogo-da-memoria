import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void testGetScore() {
        Player player = new Player();
        assertFalse(45 == player.getScore());
    }
}
