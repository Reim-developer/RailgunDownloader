/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DownloadButton.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.youtubeUI

import railgunDownloaderV4.components.ulti.*
import railgunDownloaderV4.components.youtubeUI.helper.DownloadHelper
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame

class DownloadButton(private val youtubeUIContext: YoutubeUI) {

    private val downloadHelper: DownloadHelper by lazy { DownloadHelper() }
    private val messageDialog: MessageDialog by lazy { MessageDialog() }
    private val setIconButton: SetIconButton by lazy { SetIconButton() }
    private val matchURL: MatchURL by lazy { MatchURL() }
    private val dirExists: DirExists by lazy { DirExists() }
    private val clearEvents: ClearEvents by lazy { ClearEvents() }

    fun setDownloadButton(app: JFrame, downloadButton: JButton) {
        setIconButton.setIcon(
            downloadButton,
            "/Download.png",
            60, 60
        )
        downloadButton.size = Dimension(60, 60)
        downloadButton.border = null
        downloadButton.isFocusPainted = false
        downloadButton.isBorderPainted = false
        downloadButton.isContentAreaFilled = false
        downloadButton.location = Point(200, 415)

        downloadButton.toolTipText = "Download video"
        download(downloadButton)

        app.add(downloadButton)
    }

    private fun download(downloadButton: JButton) {
        clearEvents.clearActionListeners(downloadButton)

        downloadButton.addActionListener {
            val inputURLValue = youtubeUIContext.urlField.text
            val savePathValue = youtubeUIContext.pathField.text
            val qualityValue = youtubeUIContext.qualityBox.selectedValue

            matchURL.takeIf { !it.matchURL(inputURLValue) }?.let {
                messageDialog.showMessageNotification(
                    "Please input exists video URL"
                )
                return@addActionListener
            }

            dirExists.takeIf { !it.checkDirExists(savePathValue) }?.let {
                messageDialog.showMessageNotification(
                    "Please choose exists save directory"
                )
                return@addActionListener
            }

            downloadHelper.startDownload(
                youtubeUIContext.resultLog, inputURLValue,
                qualityValue, savePathValue
            )
        }
    }
}