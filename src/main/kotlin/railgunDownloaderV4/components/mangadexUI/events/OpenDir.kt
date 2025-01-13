/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: OpenDir.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.mangadexUI.events

import railgunDownloaderV4.components.mangadexUI.MangaDexUI
import railgunDownloaderV4.components.ulti.ClearEvents
import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.filechooser.FileSystemView

class OpenDir (private val mangaDexUI: MangaDexUI){

    private val clearEvents: ClearEvents by lazy { ClearEvents() }

    fun setOpenDir(openDirButton: JButton) {
        clearEvents.clearActionListeners(openDirButton)
        openDirButton.addActionListener {
            
            val chooser = JFileChooser(FileSystemView.getFileSystemView())
            chooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
            chooser.dialogTitle = "Download manga from MangaDex"

            chooser.takeIf { it.showOpenDialog(null) == JFileChooser.APPROVE_OPTION }?.let {
                mangaDexUI.mangaDexSaveDir.text = it.selectedFile.absolutePath
            }
        }
    }
}