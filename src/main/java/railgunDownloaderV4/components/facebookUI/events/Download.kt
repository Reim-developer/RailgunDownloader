/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * Download.kt
 */
package railgunDownloaderV4.components.facebookUI.events
import railgunDownloaderV4.components.facebookUI.FacebookUI
import railgunDownloaderV4.components.facebookUI.helper.FacebookDownloadHelper
import railgunDownloaderV4.components.ulti.ClearEvents
import railgunDownloaderV4.components.ulti.DirExists
import railgunDownloaderV4.components.ulti.MatchURL
import railgunDownloaderV4.components.ulti.MessageDialog
import javax.swing.JButton


class Download (private val facebookUI: FacebookUI){

    private val clearEvents: ClearEvents by lazy { ClearEvents() }
    private val matchURL: MatchURL by lazy { MatchURL() }
    private val dirExists: DirExists by lazy { DirExists() }
    private val messageDialog: MessageDialog by lazy {  MessageDialog() }
    private val facebookDownloadHelper: FacebookDownloadHelper by lazy { FacebookDownloadHelper() }

    fun setDownload(downloadButton: JButton) {

        clearEvents.clearActionListeners(downloadButton)

        downloadButton.addActionListener {
            val urlField = facebookUI.inputURLField.text
            val pathField = facebookUI.inputPathField.text

            matchURL.takeIf { !it.matchURL(urlField) }?.let {
                messageDialog.showMessageNotification("Invalid URL. Please try again")
                return@addActionListener
            }

            dirExists.takeIf { !it.checkDirExists(pathField) }?.let {
                messageDialog.showMessageNotification("Invalid directory. Please try again")
                return@addActionListener
            }

            facebookDownloadHelper.start(
                "bin/FacebookHelper/FacebookHelper.lib", pathField,
                urlField, "best", facebookUI.logResultArea
            )
        }
    }
}