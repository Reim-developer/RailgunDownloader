/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * Application.java
 */
package railgunDownloaderV4;
import railgunDownloaderV4.components.Youtube;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Application {
    public JFrame App;
    private final Youtube YoutubeComponent;
    private final JButton YoutubeButton;
    public Application() {
        App = new JFrame();
        YoutubeButton = new JButton();
        YoutubeComponent = new Youtube(this);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Application AppScene = new Application();
            AppScene.SetProperty();
            AppScene.YoutubeComponent.SetYoutubeButton(AppScene.YoutubeButton);
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
