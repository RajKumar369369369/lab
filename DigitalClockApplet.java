package jdbc_demo;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClockApplet extends JApplet {
    private JLabel timeLabel;
    
    public void init() {
        setLayout(new FlowLayout());
        timeLabel = new JLabel();
        add(timeLabel);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                updateTime();
            }
        }, 0, 1000);
    }

    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdf.format(System.currentTimeMillis());
        timeLabel.setText(currentTime);
    }
}
