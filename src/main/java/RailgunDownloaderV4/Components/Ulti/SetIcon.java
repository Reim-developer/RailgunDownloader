package RailgunDownloaderV4.Components.Ulti;

import javax.swing.*;
import java.awt.*;

public class SetIcon {
    public Image AppIcon() {
        return new ImageIcon(
                Toolkit.getDefaultToolkit()
                        .getImage(getClass().getResource("/AppIcon.jpg"))
        );
    }
}
