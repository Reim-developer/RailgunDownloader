/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: Download.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */

package railgunDownloaderV4.components.instagramUI.events

import railgunDownloaderV4.components.global.events.DownloadVideoProcess
import railgunDownloaderV4.components.ulti.ClearEvents
import railgunDownloaderV4.components.ulti.DirExists
import railgunDownloaderV4.components.ulti.MatchURL
import railgunDownloaderV4.components.ulti.MessageDialog
import javax.swing.JButton
import javax.swing.JTextArea
import javax.swing.JTextField

class Download (
    private val urlField: JTextField,
    private val pathField: JTextField,
    private val logArea: JTextArea
){

    private val clearEvents: ClearEvents by lazy { ClearEvents() }
    private val dirExists: DirExists by lazy { DirExists() }
    private val matchURL: MatchURL by lazy { MatchURL() }
    private val messageDialog: MessageDialog by lazy { MessageDialog() }
    private val downloadVideoProcess: DownloadVideoProcess by lazy { DownloadVideoProcess() }

    fun setDownload(buttonTarget: JButton) {
        clearEvents.clearActionListeners(buttonTarget)

        buttonTarget.addActionListener {
            matchURL.takeIf { !it.matchURL(urlField.text) }?.let {
                messageDialog.showMessageNotification("Please input valid Instagram URL")
                return@addActionListener
            }

            dirExists.takeIf { !it.checkDirExists(pathField.text) }?.let {
                messageDialog.showMessageNotification("Please choose valid save directory path")
                return@addActionListener
            }

            downloadVideoProcess.setDownloadVideoProcess(
                urlField.text, pathField.text,
                logArea, "best"
            )
        }
    }
}