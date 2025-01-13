/*
 * RAILGUN DOWNLOADER - VERSION 4.0.0
 * File: OpenPath.kt
 * This project is licensed GPL-3.0 License.
 * LICENSE: https://www.gnu.org/licenses/gpl-3.0.html
 * Contribution: Reim
 */
package railgunDownloaderV4.components.facebookUI

import railgunDownloaderV4.components.ulti.PathDialog
import railgunDownloaderV4.components.ulti.SetIconButton
import java.awt.Dimension
import java.awt.Point
import javax.swing.JButton
import javax.swing.JFrame

class OpenPath (private val facebookUI: FacebookUI){

    private val setIconButton: SetIconButton by lazy { SetIconButton() }
    private val pathDialog: PathDialog by lazy { PathDialog() }

    fun setOpenPath(app: JFrame, openSavePath: JButton) {
        openSavePath.apply {
            size = Dimension(50, 50)
            isContentAreaFilled = false
            border = null
            isFocusPainted = false
            isBorderPainted = false
            location = Point(100, 440)
            setIconButton.setIcon(
                openSavePath, "/FolderPath.png",
                50, 50
            )
            toolTipText = "Choose save directory"
        }

        pathDialog.setShowDialog(
            openSavePath, "Choose save video facebook directory",
            facebookUI.inputPathField
        )
        app.add(openSavePath)
    }
}