package RailgunDownloaderV4.Components.YoutubeUI;

import javax.swing.*;
import java.awt.*;

public class QualityList {
    public void SetQuality(JFrame App, JList<String> QualityListBox) {
        String[] QualityItems = {
                "best",
                "worst",
                "bestvideo",
                "worstvideo",
                "bestaudio",
                "worstaudio",
                "1080p",
                "720p",
                "480p",
                "360p",
                "144p"
        };

        QualityListBox.setListData(QualityItems);
        QualityListBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        QualityListBox.setSize(new Dimension(70, 180));
        QualityListBox.setLocation(new Point(330, 420));
        QualityListBox.setBackground(new Color(21, 21, 21));
        QualityListBox.setForeground(Color.WHITE);
        QualityListBox.setSelectedIndex(0);
        QualityListBox.setFont(new Font("Consolas", Font.PLAIN, 10));

        QualityListBox.setToolTipText("Choose your video quality");

        QualityListBox.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel QualityListLabel = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                QualityListLabel.setHorizontalAlignment(SwingConstants.CENTER);
                return QualityListLabel;
            }
        });

        App.add(QualityListBox);
    }
}
