/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: DownloadButton.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.nhentaiUI

import railgunDownloaderV4.components.nhentaiUI.helper.NhentaiDownloadHelper
import railgunDownloaderV4.components.ulti.ClearEvents
import railgunDownloaderV4.components.ulti.DirExists
import railgunDownloaderV4.components.ulti.MatchURL
import railgunDownloaderV4.components.ulti.MessageDialog
import java.awt.Image
import java.awt.Toolkit
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JTextArea
import javax.swing.JTextField
import javax.swing.SwingUtilities

class DownloadButton(
    private val urlField: JTextField,
    private val savePathField: JTextField,
    private val logResultArea: JTextArea
    ) {
    private val matchURL: MatchURL by lazy { MatchURL() }
    private val dirExists: DirExists by lazy { DirExists() }
        private val downloadHelper: NhentaiDownloadHelper by lazy { NhentaiDownloadHelper(urlField, savePathField, logResultArea) }
    private val clearEvents: ClearEvents by lazy { ClearEvents() }
    private val messageDialog: MessageDialog by lazy { MessageDialog() }

    fun setDownloadButton(app: JFrame, downloadButton: JButton) {
        downloadButton.setSize(50, 50)
        downloadButton.isBorderPainted = false
        downloadButton.isFocusPainted = false

        val buttonIcon = Toolkit.getDefaultToolkit()
            .getImage(this::class.java.getResource("/Download.png"))

        downloadButton.icon = ImageIcon(
            buttonIcon.getScaledInstance(50, 50, Image.SCALE_FAST)
        )
        downloadButton.isContentAreaFilled = false
        downloadButton.setLocation(170, 450)
        downloadButton.toolTipText = "Download doujinshi"

        downloadAction(downloadButton)

        app.add(downloadButton)
    }

    private fun downloadAction(downloadButton: JButton) {

        clearEvents.clearActionListeners(downloadButton)

        downloadButton.addActionListener {
            val inputURL = urlField.text
            val savePathDir = savePathField.text

            matchURL.takeIf { !it.matchURL(inputURL) }?.let {
                messageDialog.showMessageNotification("Please input valid URL")
                return@addActionListener
            }

            dirExists.takeIf { !it.checkDirExists(savePathDir) }?.let {
                messageDialog.showMessageNotification("Please choose exists save directory path")
                return@addActionListener
            }

            SwingUtilities.invokeLater { downloadHelper.executeDownload("BY_URL") }
        }
    }
}