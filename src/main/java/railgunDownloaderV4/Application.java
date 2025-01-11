/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * Application.java
 */
package railgunDownloaderV4;
import railgunDownloaderV4.components.Facebook;
import railgunDownloaderV4.components.MangaDex;
import railgunDownloaderV4.components.Youtube;
import railgunDownloaderV4.components.Nhentai;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Application {
    public JFrame App;
    private final Youtube YoutubeComponent;
    private final Nhentai nhentaiComponent;
    private final Facebook facebookComponent;
    private final MangaDex mangaDexComponent;

    private final JButton YoutubeButton;
    private final JButton nhentaiButton;
    private final JButton facebookButton;
    private final JButton mangaDexButton;


    public Application() {
        App = new JFrame();
        YoutubeComponent = new Youtube(this);
        nhentaiComponent = new Nhentai(this);
        facebookComponent = new Facebook(this);
        mangaDexComponent = new MangaDex(this);

        YoutubeButton = new JButton();
        nhentaiButton = new JButton();
        facebookButton = new JButton();
        mangaDexButton = new JButton();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Application AppScene = new Application();
            AppScene.SetProperty();
            AppScene.YoutubeComponent.SetYoutubeButton(AppScene.YoutubeButton);
            AppScene.nhentaiComponent.setNhentaiUIButton(AppScene.nhentaiButton);
            AppScene.facebookComponent.setFacebookButton(AppScene.facebookButton);
            AppScene.mangaDexComponent.setMangaDex(AppScene.mangaDexButton);
        });
    }

    private void SetProperty() {
        App.setTitle("Railgun Downloader V4");
        App.setIconImage(
               Objects.requireNonNull(
                       Toolkit.getDefaultToolkit()
                               .getImage(getClass().getResource("/AppIcon.jpg"))
               )
        );
        App.setSize(600, 600);
        App.setMaximumSize(new Dimension(600, 600));
        App.setLayout(null);
        App.setLocationRelativeTo(null);
        App.getContentPane().setBackground(new Color(21, 21, 21));
        App.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        App.setResizable(false);
        App.setVisible(true);
    }
}
