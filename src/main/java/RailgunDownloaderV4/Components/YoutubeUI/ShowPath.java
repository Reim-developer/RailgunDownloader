/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * ShowPath.java
 */
package RailgunDownloaderV4.Components.YoutubeUI;
import javax.swing.*;
import java.awt.*;

public class ShowPath {
    public void SetShowPath(JFrame App, JTextField ShowPathField) {
        ShowPathField.setSize(new Dimension(400, 30));
        ShowPathField.setBorder(null);
        ShowPathField.setFont(new Font("Consolas", Font.PLAIN, 15));
        ShowPathField.setEditable(false);
        ShowPathField.setBackground(new Color(69, 69, 69));
        ShowPathField.setForeground(Color.WHITE);
        ShowPathField.setLocation(new Point(100, 300));

        ShowPathField.setToolTipText("Your chosen path is displayed here");

        App.add(ShowPathField);
    }
}
