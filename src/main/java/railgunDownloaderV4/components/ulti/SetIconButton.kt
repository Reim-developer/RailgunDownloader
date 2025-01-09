/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * SetIconButton.kt
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