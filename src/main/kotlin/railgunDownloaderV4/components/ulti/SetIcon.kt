/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: SetIcon.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

import java.awt.Image
import java.awt.Toolkit
import java.util.*

class SetIcon {
    fun setAppIcon(): Image {
        return Objects.requireNonNull(
            Toolkit.getDefaultToolkit()
                .getImage(javaClass.getResource("/AppIcon.jpg"))
        )
    }
}
