/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: ChoosePath.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.nhentaiUI

import railgunDownloaderV4.components.ulti.ClearEvents
import java.awt.Image
import java.awt.Toolkit
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.filechooser.FileSystemView

class ChoosePath (private val nhentaiUI: NhentaiUI) {
    private val clearEvents: ClearEvents by lazy { ClearEvents() }

    fun setChoosePath(app: JFrame, choosePathButton: JButton) {
        choosePathButton.setSize(50, 50)
        choosePathButton.isContentAreaFilled = false
        choosePathButton.setLocation(100, 450)
        choosePathButton.border = null

        val buttonIcon = Toolkit.getDefaultToolkit()
            .getImage(this::class.java.getResource("/FolderPath.png"))

        choosePathButton.icon = ImageIcon(
            buttonIcon.getScaledInstance(50, 50, Image.SCALE_FAST)
        )

        openSaveDir(choosePathButton)
        app.add(choosePathButton)
    }

    private fun openSaveDir(choosePathButton: JButton) {

        clearEvents.clearActionListeners(choosePathButton)

        choosePathButton.addActionListener { _ ->
            val chooser = JFileChooser(FileSystemView.getFileSystemView())
            chooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
            chooser.dialogTitle = "Save doujinshi"

            chooser.takeIf { it.showOpenDialog(null) == JFileChooser.APPROVE_OPTION }?.selectedFile?.let {
                nhentaiUI.pathField.text = it.absolutePath
            }
        }
    }
}