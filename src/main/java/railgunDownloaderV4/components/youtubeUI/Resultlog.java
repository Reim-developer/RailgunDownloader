package railgunDownloaderV4.components.YoutubeUI;
import javax.swing.*;
import java.awt.*;

public class Resultlog {
    public void SetResultlog(JFrame App, JTextArea ResultArea) {
        ResultArea.setFont(new Font("Consolas", Font.PLAIN, 10));
        ResultArea.setEditable(false);
        ResultArea.setWrapStyleWord(true);
        ResultArea.setLineWrap(true);
        ResultArea.setBackground(new Color(69, 69, 69));
        ResultArea.setForeground(Color.WHITE);
        ResultArea.setToolTipText("Your download result will be displayed here");

        JScrollPane ScrollPanel = new JScrollPane(ResultArea);
        ScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        ScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        ScrollPanel.setSize(new Dimension(400, 200));
        ScrollPanel.setLocation(new Point(100, 50));
        ScrollPanel.setBorder(null);

        App.add(ScrollPanel);
    }
}
