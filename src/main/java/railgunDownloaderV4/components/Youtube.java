/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * Youtube.java
 */
package railgunDownloaderV4.components;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import railgunDownloaderV4.Application;
import railgunDownloaderV4.components.youtubeUI.YoutubeUI;

public class Youtube {
    private final Application AppScene;
    private  final YoutubeUI UIContext;

    public  Youtube(Application AppScene) {
        this.AppScene = AppScene;
        UIContext = new YoutubeUI(AppScene);
    }

    public  void SetYoutubeButton(JButton YoutubeButton) {
        YoutubeButton.setSize(50, 50);
        YoutubeButton.setBorderPainted(false);
        YoutubeButton.setBorder(null);
        YoutubeButton.setContentAreaFilled(false);
        YoutubeButton.setFocusPainted(false);

        Image ButtonIcon = Toolkit.getDefaultToolkit().getImage(
                Objects.requireNonNull(
                        getClass().getResource("/YoutubeIcon.png")
                )
        );
        YoutubeButton.setIcon(new ImageIcon(
                ButtonIcon.getScaledInstance(50, 50, Image.SCALE_FAST)
        ));

        YoutubeButton.setToolTipText("Download video from Youtube");

        OpenYoutubeUI(YoutubeButton);
        AppScene.App.add(YoutubeButton);
    }

    private void OpenYoutubeUI(JButton YoutubeButton) {
        SwingUtilities.invokeLater(() ->
                YoutubeButton.addActionListener(actionEvent -> {
                UIContext.ShowYoutubeUI(true);
                AppScene.App.setVisible(false);
        }));
    }
}
