import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Stopwatch {
    JLabel timeLabel = new JLabel();
    private int elapsedTime = 60000;
    int seconds = 0;
    int minutes = 0;
    boolean started = false;
    String secondsString = String.format("%02d", seconds);
    String minutesString = String.format("%02d", minutes);
    Font defaultFont = new Font("Press Start 2P", Font.PLAIN, 20);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            elapsedTime -= 1000;
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            updateTimeLabel();
        }
    });

    public Stopwatch() {


        timeLabel.setText(minutesString + ":" + secondsString);
        timeLabel.setBounds(280,20,150,60);
        timeLabel.setFont(defaultFont);
        timeLabel.setForeground(Color.white);
        timeLabel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createBevelBorder(BevelBorder.LOWERED),
            "Tempo", TitledBorder.LEFT, TitledBorder.TOP, defaultFont,
            Color.red));
        timeLabel.setOpaque(false);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setLayout(null);
    }

    private void updateTimeLabel(){
        if(elapsedTime == 0) {
            stop();
        }
        String seconds_string = String.format("%02d", seconds);
        String minutes_string = String.format("%02d", minutes);
        timeLabel.setText(minutes_string + ":" + seconds_string);
    }

    public void start() {
        timer.start();
        
    }

    public void stop() {
        timer.stop();
    }

    public JLabel getLabel() {
        return timeLabel;
    }    

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int seconds) {
        elapsedTime = seconds*1000;
    }
}
