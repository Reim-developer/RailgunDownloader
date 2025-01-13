/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Youtube.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.youtubeUI.YoutubeUI
import java.awt.Image
import java.awt.Toolkit
import java.util.*
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.SwingUtilities

class Youtube(private val appScene: Application) {
    private val uiContext = YoutubeUI(appScene)

    fun setYoutubeButton(youtubeButton: JButton) {
        youtubeButton.setSize(50, 50)
        youtubeButton.isBorderPainted = false
        youtubeButton.border = null
        youtubeButton.isContentAreaFilled = false
        youtubeButton.isFocusPainted = false

        val buttonIcon = Toolkit.getDefaultToolkit().getImage(
            Objects.requireNonNull(
                javaClass.getResource("/YoutubeIcon.png")
            )
        )
        youtubeButton.icon = ImageIcon(
            buttonIcon.getScaledInstance(50, 50, Image.SCALE_FAST)
        )

        youtubeButton.toolTipText = "Download video from Youtube"

        openYoutubeUI(youtubeButton)
        appScene.app.add(youtubeButton)
    }

    private fun openYoutubeUI(youtubeUI: JButton) {
        SwingUtilities.invokeLater {
            youtubeUI.addActionListener {
                uiContext.showYoutubeUI(true)
                appScene.app.isVisible = false
            }
        }
    }
}
