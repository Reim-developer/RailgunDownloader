/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * CancelDownload.java
 */
package railgunDownloaderV4.components.youtubeUI;
import railgunDownloaderV4.components.ulti.ProcessCancel;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class CancelDownload {
    private final ProcessCancel cancelProcess;
    public CancelDownload() {
        cancelProcess = new ProcessCancel();
    }
    public void SetCancelDownload(JFrame App, JButton CancelDownloadButton) {
        CancelDownloadButton.setSize(new Dimension(50, 50));
        CancelDownloadButton.setBorder(null);
        CancelDownloadButton.setBorderPainted(false);
        CancelDownloadButton.setFocusPainted(false);

        Image ButtonIcon = Toolkit.getDefaultToolkit().getImage(
                Objects.requireNonNull(getClass()
                        .getResource("/Cancel.png"))
        );

        CancelDownloadButton.setLocation(new Point(202, 490));
        CancelDownloadButton.setIcon(new ImageIcon(
                ButtonIcon.getScaledInstance(50, 50, Image.SCALE_FAST)
        ));
        CancelDownloadButton.setContentAreaFilled(false);
        CancelDownloadButton.setToolTipText("Cancel download");

        CancelDownloadButton.addActionListener(a -> CancelDownloadHelper());
        App.add(CancelDownloadButton);
    }

    private void CancelDownloadHelper() {
        cancelProcess.taskKill("Youtube.lib");
        JOptionPane.showMessageDialog(
                null,
                "Successfully end process",
                "Info",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
