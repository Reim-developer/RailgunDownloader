/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * InputURL.java
 */
package railgunDownloaderV4.components.YoutubeUI;
import javax.swing.*;
import java.awt.*;

public class InputURL {
    public  void SetInputURL(JFrame App, JTextField URLInput) {
        URLInput.setSize(new Dimension(400, 30));
        URLInput.setBorder(null);
        URLInput.setBackground(new Color(69, 69, 69));
        URLInput.setForeground(Color.WHITE);
        URLInput.setFont(new Font("Consolas", Font.PLAIN, 15));
        URLInput.setLocation(new Point(100, 370));

        URLInput.setToolTipText("Input your Youtube URL here.");

        App.add(URLInput);
    }
}
