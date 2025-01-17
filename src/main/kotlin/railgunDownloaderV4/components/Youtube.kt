/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Youtube.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components

import railgunDownloaderV4.Application
import railgunDownloaderV4.components.ulti.ClearEvents
import railgunDownloaderV4.components.youtubeUI.YoutubeUI
import java.awt.Image
import java.awt.Toolkit
import java.util.*
import javax.swing.ImageIcon
import javax.swing.JButton

class Youtube(private val appScene: Application) {
    private val youtubeUI: YoutubeUI by lazy { YoutubeUI(appScene) }
    private val clearEvents: ClearEvents by lazy { ClearEvents() }

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

    private fun openYoutubeUI(buttonTarget: JButton) {
        clearEvents.clearActionListeners(buttonTarget)

        buttonTarget.addActionListener {
            youtubeUI.showYoutubeUI(true)
            appScene.app.isVisible = false
        }

    }
}
