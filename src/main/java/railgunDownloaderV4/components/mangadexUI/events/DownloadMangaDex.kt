/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * DownloadMangaDex.kt
 */
package railgunDownloaderV4.components.mangadexUI.events

import railgunDownloaderV4.components.ulti.ClearEvents
import railgunDownloaderV4.components.ulti.DirExists
import railgunDownloaderV4.components.ulti.MessageDialog
import javax.swing.JButton
import javax.swing.JTextField

class DownloadMangaDex (private val inputURLField: JTextField, private val saveDirField: JTextField){

    private val clearEvents: ClearEvents by lazy { ClearEvents() }
    private val dirExists: DirExists by lazy { DirExists() }
    private val messageDialog: MessageDialog by lazy { MessageDialog() }

    fun download(downloadButton: JButton) {
        clearEvents.clearActionListeners(downloadButton)

        downloadButton.addActionListener {
            val urlField = inputURLField.text
            val saveDirField = saveDirField.text

            urlField.takeIf { it.isNullOrBlank() }?.let {
                messageDialog.showMessageNotification("Please input MangaDex ID")
                return@addActionListener
            }

            dirExists.takeIf { !it.checkDirExists(saveDirField) }?.let {
                messageDialog.showMessageNotification("Please choose save directory")
                return@addActionListener
            }
        }
    }
}