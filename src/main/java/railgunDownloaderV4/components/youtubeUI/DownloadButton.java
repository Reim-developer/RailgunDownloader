/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * DownloadButton.java
 */
package railgunDownloaderV4.components.YoutubeUI;
import railgunDownloaderV4.components.YoutubeUI.Helper.DownloadHelper;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.io.File;

public class DownloadButton {
    private final YoutubeUI YoutubeUIContext;
    private final DownloadHelper Helper;

    public DownloadButton(YoutubeUI YoutubeUIContext) {
        this.YoutubeUIContext = YoutubeUIContext;
        Helper = new DownloadHelper();
    }
    public void SetDownloadButton(JFrame App, JButton DownloadButton) {
        Image ButtonIcon = Toolkit.getDefaultToolkit().getImage(
                Objects.requireNonNull(getClass().getResource("/Download.png"))
        );
        DownloadButton.setSize(new Dimension(60, 60));
        DownloadButton.setIcon(new ImageIcon(ButtonIcon.getScaledInstance(60, 60, Image.SCALE_FAST)));
        DownloadButton.setBorder(null);
        DownloadButton.setFocusPainted(false);
        DownloadButton.setBorderPainted(false);
        DownloadButton.setContentAreaFilled(false);
        DownloadButton.setLocation(new Point(200, 415));

        DownloadButton.setToolTipText("Download video");

        Download(DownloadButton);

        App.add(DownloadButton);
    }

    private void Download(JButton DownloadButton) {
        DownloadButton.addActionListener(e -> {
            String InputURLValue = YoutubeUIContext.InputURLField.getText();
            String SavePathValue = YoutubeUIContext.ShowPathField.getText();
            String ChooseValue = YoutubeUIContext.QualityListBox.getSelectedValue();

            File SaveFolder = new File(SavePathValue);

            if(InputURLValue.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please input your Youtube video URL",
                        "Notification",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }

            if(!SaveFolder.exists() && !SaveFolder.isDirectory()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Your save folder is not exists. Please try again",
                        "Notification",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
            Helper.StartDownload(YoutubeUIContext.LogResult,InputURLValue, ChooseValue, SavePathValue);
        });
    }
}
