/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * DownloadButton.java
 */
package railgunDownloaderV4.components.youtubeUI;
import railgunDownloaderV4.components.ulti.DirExists;
import railgunDownloaderV4.components.ulti.MatchURL;
import railgunDownloaderV4.components.ulti.MessageDialog;
import railgunDownloaderV4.components.ulti.SetIconButton;
import railgunDownloaderV4.components.youtubeUI.helper.DownloadHelper;
import javax.swing.*;
import java.awt.*;

public class DownloadButton {
    private final YoutubeUI YoutubeUIContext;
    private final DownloadHelper Helper;
    private final MessageDialog messageDialog;
    private final SetIconButton setIconButton;
    private final MatchURL matchURL;
    private final DirExists dirExists;

    public DownloadButton(YoutubeUI YoutubeUIContext) {
        this.YoutubeUIContext = YoutubeUIContext;
        Helper = new DownloadHelper();
        messageDialog = new MessageDialog();
        setIconButton = new SetIconButton();
        matchURL = new MatchURL();
        dirExists = new DirExists();
    }
    public void SetDownloadButton(JFrame App, JButton DownloadButton) {
        setIconButton.setIcon(
                DownloadButton,
                "/Download.png",
                60, 60
        );
        DownloadButton.setSize(new Dimension(60, 60));
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

            if(!matchURL.matchURL(InputURLValue)) {
                messageDialog.showMessageNotification(
                        "Please input valid Youtube video URL",
                        "notification"
                );
                return;
            }

            if(!dirExists.checkDirExists(SavePathValue)) {
                messageDialog.showMessageNotification(
                        "Your save folder is not exists. Please try again",
                        "Notification"
                );
                return;
            }
            Helper.StartDownload(YoutubeUIContext.LogResult,InputURLValue, ChooseValue, SavePathValue);
        });
    }
}