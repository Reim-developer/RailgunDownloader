package railgunDownloaderV4.components.ulti;
import java.awt.*;
import java.util.Objects;

public class SetIcon {
    public Image AppIcon() {
        return Objects.requireNonNull(
                Toolkit.getDefaultToolkit()
                        .getImage(getClass().getResource("/AppIcon.jpg"))
        );
    }
}
