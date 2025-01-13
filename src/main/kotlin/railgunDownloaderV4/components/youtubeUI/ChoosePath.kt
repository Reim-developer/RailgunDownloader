/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: ChoosePath.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.youtubeUI

import railgunDownloaderV4.components.ulti.SetIconButton
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFileChooser
import javax.swing.JFrame

class ChoosePath(private val youtubeUI: YoutubeUI) {

    private val setIconButton: SetIconButton by lazy { SetIconButton() }

    fun setChoosePath(app: JFrame, choosePathButton: JButton) {
        val browserFolder = JFileChooser()
        choosePathButton.border = null
        choosePathButton.location = Point(100, 420)
        choosePathButton.size = Dimension(50, 50)
        choosePathButton.isContentAreaFilled = false
        choosePathButton.isBorderPainted = false
        choosePathButton.isFocusPainted = false
        setIconButton.setIcon(
            choosePathButton, "/FolderPath.png",
            50, 50
        )
        choosePathButton.toolTipText = "Choose save directory path"

        openSaveDir(browserFolder, choosePathButton)
        app.add(choosePathButton)
    }

    private fun openSaveDir(folderBrowser: JFileChooser, choosePathButton: JButton) {
        choosePathButton.addActionListener {
            folderBrowser.fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
            folderBrowser.dialogTitle = "Choose save directory path"

            folderBrowser.takeIf { it.showOpenDialog(null) == JFileChooser.APPROVE_OPTION }?.selectedFile?.let {
                youtubeUI.pathField.text = it.absolutePath
            }
        }
    }
}
