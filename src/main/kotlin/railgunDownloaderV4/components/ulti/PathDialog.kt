/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: PathDialog.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.ulti

import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JTextField
import javax.swing.filechooser.FileSystemView

class PathDialog {

    private val clearEvents: ClearEvents by lazy { ClearEvents() }

    fun setShowDialog(openPathButton: JButton, dialogTitle: String, pathField: JTextField){

        clearEvents.clearActionListeners(openPathButton)

        openPathButton.addActionListener {
            val chooser = JFileChooser(FileSystemView.getFileSystemView())
            chooser.dialogTitle = dialogTitle
            chooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY

            chooser.takeIf {it.showOpenDialog(null) == JFileChooser.APPROVE_OPTION}?.selectedFile?.let {
                pathField.text = it.absolutePath
            }
        }
    }
}