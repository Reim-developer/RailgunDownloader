/*
 * RAILGUN DOWNLOADER VERSION 4.0.0
 * ChoosePath.java
 */
package railgunDownloaderV4.components.youtubeUI;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.io.File;

public class ChoosePath {
    private final YoutubeUI YoutubeUIContext;

    public ChoosePath(YoutubeUI YoutubeUIContext) {
        this.YoutubeUIContext = YoutubeUIContext;
    }
    public void SetChoosePath(JFrame App, JButton ChoosePathButton) {
        JFileChooser BrowserFolder = new JFileChooser();

        Image ButtonIcon = Toolkit.getDefaultToolkit().getImage(
                Objects.requireNonNull(getClass().getResource("/FolderPath.png"))
        );
        ChoosePathButton.setBorder(null);
        ChoosePathButton.setLocation(new Point(100, 420));
        ChoosePathButton.setSize(new Dimension(50, 50));
        ChoosePathButton.setContentAreaFilled(false);
        ChoosePathButton.setIcon(new ImageIcon(ButtonIcon.getScaledInstance(50, 50, Image.SCALE_FAST)));
        ChoosePathButton.setBorderPainted(false);
        ChoosePathButton.setFocusPainted(false);

        ChoosePathButton.setToolTipText("Choose save path");

        OpenSaveFolderPath(App, BrowserFolder, ChoosePathButton);
        App.add(ChoosePathButton);
    }

    private void OpenSaveFolderPath(JFrame App, JFileChooser FolderBrowser, JButton ChoosePathButton) {
        ChoosePathButton.addActionListener(e -> {
            FolderBrowser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int OpenResult = FolderBrowser.showDialog(App, "Choose save path");

            if(OpenResult == JFileChooser.APPROVE_OPTION) {
                File ChoosePath = FolderBrowser.getSelectedFile();
                YoutubeUIContext.ShowPathField.setText(ChoosePath.toString());
            }
        });
    }
}
