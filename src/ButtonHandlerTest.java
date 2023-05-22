import static org.junit.Assert.assertEquals;

import javax.swing.JButton;

import org.junit.Test;

public class ButtonHandlerTest {

    ButtonHandler buttonHandler = new ButtonHandler();

    @Test
    public void testAddHashMap() {

    }
        
    @Test
    public void testButtonClicked() {

    }

    @Test
    public void testCheckMatch() {

    }

    @Test
    public void testFormatButton() {
        JButton testButton = new JButton();
        testButton.setVisible(false);
        buttonHandler.formatButton(testButton);
        assertEquals(true, testButton.isVisible());
    }

    @Test
    public void testTurnBtn() {
        
    }
}
