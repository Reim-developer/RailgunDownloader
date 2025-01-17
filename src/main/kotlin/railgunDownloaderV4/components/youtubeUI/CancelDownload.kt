/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: CancelDownload.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.youtubeUI

import railgunDownloaderV4.components.ulti.ClearEvents
import railgunDownloaderV4.components.ulti.ProcessCancel
import railgunDownloaderV4.components.ulti.SetIconButton
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JOptionPane

class CancelDownload {

    private val cancelProcess: ProcessCancel by lazy { ProcessCancel() }
    private val setIconButton: SetIconButton by lazy { SetIconButton() }
    private val clearEvents: ClearEvents by lazy { ClearEvents() }

    fun setCancelDownload(app: JFrame, cancelDownloadButton: JButton) {
        cancelDownloadButton.size = Dimension(50, 50)
        cancelDownloadButton.border = null
        cancelDownloadButton.isBorderPainted = false
        cancelDownloadButton.isFocusPainted = false
        cancelDownloadButton.location = Point(202, 490)
        cancelDownloadButton.isContentAreaFilled = false
        setIconButton.setIcon(
            cancelDownloadButton, "/Cancel.png",
            50, 50
        )
        cancelDownloadButton.toolTipText = "Cancel download"

        cancelDownloadHelper(cancelDownloadButton)

        app.add(cancelDownloadButton)
    }

    private fun cancelDownloadHelper(buttonTarget: JButton) {
        clearEvents.clearActionListeners(buttonTarget)

        buttonTarget.addActionListener {
            cancelProcess.taskKill("Youtube.lib")
            JOptionPane.showMessageDialog(
                null,
                "Successfully end process",
                "Info",
                JOptionPane.INFORMATION_MESSAGE
            )
        }
    }
}
