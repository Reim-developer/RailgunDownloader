/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: SetIconButton.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

import java.awt.Image
import java.awt.Toolkit
import javax.swing.ImageIcon
import javax.swing.JButton

class SetIconButton {
    fun setIcon(button: JButton, iconPath: String, width: Int, height: Int) {
        val buttonIcon = Toolkit.getDefaultToolkit()
            .getImage(this::class.java.getResource(iconPath))

        button.icon = ImageIcon(
            buttonIcon.getScaledInstance(width, height, Image.SCALE_FAST)
        )
    }
}