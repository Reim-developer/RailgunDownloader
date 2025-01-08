/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * ChoosePath.kt
 */
package railgunDownloaderV4.components.nhentaiUI

import java.awt.Image
import java.awt.Toolkit
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JFrame
import javax.swing.SwingUtilities
import javax.swing.filechooser.FileSystemView

class ChoosePath (private val nhentaiUI: NhentaiUI) {

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
        choosePathButton.addActionListener { _ ->
            val chooser = JFileChooser(FileSystemView.getFileSystemView())
            chooser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
            chooser.dialogTitle = "Save doujinshi"

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                SwingUtilities.invokeLater {
                    nhentaiUI.pathField.text = chooser.selectedFile.absolutePath
                }
            }
        }
    }
}