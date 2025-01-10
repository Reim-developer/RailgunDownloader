/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * PathDialog.kt
 */
package railgunDownloaderV4.components.ulti

import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JTextField
import javax.swing.filechooser.FileSystemView

class PathDialog {
    fun setShowDialog(openPathButton: JButton, dialogTitle: String, pathField: JTextField){
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