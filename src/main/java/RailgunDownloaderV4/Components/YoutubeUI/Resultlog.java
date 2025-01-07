package RailgunDownloaderV4.Components.YoutubeUI;
import javax.swing.*;
import java.awt.*;

public class Resultlog {
    public void SetResultlog(JFrame App, JTextArea ResultArea) {
        ResultArea.setSize(new Dimension(400, 200));
        ResultArea.setFont(new Font("Consolas", Font.PLAIN, 10));
        ResultArea.setBackground(new Color(69, 69, 69));
        ResultArea.setLocation(new Point(100, 50));
        ResultArea.setForeground(Color.WHITE);
        ResultArea.setEditable(false);
        ResultArea.setToolTipText("Your download result will be displayed here");

        App.add(ResultArea);
    }
}
